package com.example.jwt.config;

import com.example.jwt.config.jwt.JwtAuthenticationFilter;
import com.example.jwt.filter.MyFilter1;
import com.example.jwt.filter.MyFilter3;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new MyFilter3(),
//                BasicAuthenticationFilter.class); // 실행되기 전에 걸어야한다.
        http.addFilterBefore(new MyFilter3(),
                SecurityContextPersistenceFilter.class);    //시큐리티는 필터체인 방식이다. 이 필터가 시큐리티의 맨 처음이다!
        http.csrf()
                .disable();
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않음
            .and()
                .addFilter(corsFilter)  // @CrossOrigin(컨트롤러 클래스 레벨에 달아주는것)는 인증이 없는경우만 사용가능, 인증이 필요할때는 필터를 달아주어야 한다.
                .formLogin().disable()  // jwt를 사용하므로 생략
                .httpBasic().disable()  //
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))   //jwt 필터 달아주기, AuthenticationManager를 던져줘야함
                .authorizeRequests()
                    .antMatchers("/api/v1/user/**")
                        .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                    .antMatchers("/api/v1/manager/**")
                        .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                    .antMatchers("/api/v1/admin/**")
                        .access("hasRole('ROLE_ADMIN')")
                    .anyRequest()
                        .permitAll();
    }
}

package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  // 스프링 시큐리티 필터가 스프링 필터체인에 등록된다.
//securedEnabled > @Secured 활성화
//prePostEnabled > @preAuthorize, @postAuthorize 활성화
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean   //해당 메서드의 리턴되는 오브젝트를 IoC로 등록
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()    //인증만 되었다면 들어갈 수 있는 곳!
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/loginForm")        //인증이 되지 않은 유저가 접근하는 경우 자동으로 로그인하게끔 하는 역할
                .loginProcessingUrl("/login")   //매개변수 주소가 호출되면 시큐리티가 가로채서 대신 로그인을 진행해준다.
                                                // 이로 인해 컨트롤러에 /login을 작성하지 않아도 된다.
                .defaultSuccessUrl("/")         // 로그인 성공시 이동 페이지
                                                // 즉, loginForm을 요청했을 때 인증되지 않았다면 로그인 후 '/' 경로로 이동, 
                                                // 그렇지 않은 경우는 로그인후 원래 요청했던 경로로 이동
            .and()
                .oauth2Login()
                .loginPage("/loginForm");       // 여기까지는 인증만 되고 로그인한 회원의 정보가 세션에 없다.
                                                // 후처리가 필요하다.
    }
}

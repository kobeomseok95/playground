package com.example.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   // 내 서버가 응답할 때 json을 javascript에서 처리할 수 있게 할지 설정
        config.addAllowedOrigin("*");       // 모든 Origin(ip)에게 응답을 허용
        config.addAllowedHeader("*");       // 모든 header에 응답 허용
        config.addAllowedMethod("*");       // 모든 메서드(post, get..)에 응답 허용
        source.registerCorsConfiguration("/api/**", config);    // /api의 하위 리소스에는 이 config를 설정
        return new CorsFilter(source);
    }
}

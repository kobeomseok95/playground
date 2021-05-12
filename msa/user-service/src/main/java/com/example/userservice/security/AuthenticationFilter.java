package com.example.userservice.security;

import com.example.userservice.vo.RequestLogin;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        //inputStream 은 Body의 요청값을 꺼내기 위해서 사용!
        RequestLogin creds = new ObjectMapper().readValue(request.getInputStream(), RequestLogin.class);

        // 인증 처리
        return getAuthenticationManager()
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                creds.getEmail(),
                                creds.getPassword(),
                                new ArrayList<>()
                        )
                );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        super.successfulAuthentication(request, response, chain, authResult);
    }
}

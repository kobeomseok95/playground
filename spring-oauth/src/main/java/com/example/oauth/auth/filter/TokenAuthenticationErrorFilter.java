package com.example.oauth.auth.filter;

import com.example.oauth.common.exception.auth.TokenAuthenticationFilterException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthenticationErrorFilter extends OncePerRequestFilter {

    private final String MESSAGE = "로그인에 실패했습니다.";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (TokenAuthenticationFilterException e) {
            log.info("[TokenAuthenticationErrorFilter] Responding with unauthorized error - {}", e.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, MESSAGE);
        }
    }
}

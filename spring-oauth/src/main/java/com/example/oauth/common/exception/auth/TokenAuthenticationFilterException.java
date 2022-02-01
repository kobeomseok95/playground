package com.example.oauth.common.exception.auth;

import org.springframework.http.HttpStatus;

public class TokenAuthenticationFilterException extends AuthException {
    private static final String MESSAGE = "JWT 토큰 통신에 실패했습니다.";
    private static final String CODE = "LOGIN-400";

    public TokenAuthenticationFilterException() {
        super(CODE, HttpStatus.BAD_REQUEST, MESSAGE);
    }
}

package com.example.oauth.common.exception.auth;

import org.springframework.http.HttpStatus;

public class HttpMethodNotSupportedException extends AuthException {
    private static final String MESSAGE = "지원하지 않는 HTTP METHOD 입니다.";
    private static final String CODE = "LOGIN-405";

    public HttpMethodNotSupportedException() {
        super(CODE, HttpStatus.METHOD_NOT_ALLOWED, MESSAGE);
    }
}

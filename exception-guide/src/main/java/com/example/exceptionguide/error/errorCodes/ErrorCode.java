package com.example.exceptionguide.error.errorCodes;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND(404, "M404", "가입되지 않은 회원입니다."),
    NOT_LOGIN(401, "M401", "로그인 하지 않았습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

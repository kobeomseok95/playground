package com.example.solid.modules.common.exception.member;

import com.example.solid.modules.common.exception.ErrorBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
enum MemberErrorCodes implements ErrorBase {

    MEMBER_DUPLICATE(400, "이미 가입한 회원입니다.", "M-400");

    private int stateCode;
    private String message;
    private String errorCode;

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public int getStateCode() {
        return stateCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getName() {
        return name();
    }
}

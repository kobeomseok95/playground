package com.example.exceptionguide.error.exceptions;

import com.example.exceptionguide.error.errorCodes.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberNotLoginException extends BusinessException {

    public MemberNotLoginException(String message) {
        super(message, ErrorCode.NOT_LOGIN);
    }
}

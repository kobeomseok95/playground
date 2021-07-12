package com.example.exceptionguide.error.exceptions;

import com.example.exceptionguide.error.errorCodes.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberNotFoundException extends BusinessException {

    public MemberNotFoundException(String message) {
        super(message, ErrorCode.NOT_FOUND);
    }
}

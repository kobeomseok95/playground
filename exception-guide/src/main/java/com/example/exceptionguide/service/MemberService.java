package com.example.exceptionguide.service;

import com.example.exceptionguide.error.errorCodes.ErrorCode;
import com.example.exceptionguide.error.exceptions.MemberNotFoundException;
import com.example.exceptionguide.error.exceptions.MemberNotLoginException;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public void notFound(Long memberId) {
        throw new MemberNotFoundException(ErrorCode.NOT_FOUND.getMessage());
    }

    public void notLogin(Long memberId) {
        throw new MemberNotLoginException(ErrorCode.NOT_LOGIN.getMessage());
    }
}

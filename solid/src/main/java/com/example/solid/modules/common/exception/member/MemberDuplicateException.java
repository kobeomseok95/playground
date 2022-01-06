package com.example.solid.modules.common.exception.member;

import com.example.solid.modules.common.exception.BusinessException;
import lombok.Getter;

@Getter
public class MemberDuplicateException extends BusinessException {

    public MemberDuplicateException() {
        super(MemberErrorCodes.MEMBER_DUPLICATE);
    }
}

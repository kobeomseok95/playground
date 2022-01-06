package com.example.solid.modules.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class BusinessException extends RuntimeException implements ErrorBase {

    private ErrorBase errorBase;

    public BusinessException(ErrorBase errorBase) {
        super(errorBase.getMessage());
        this.errorBase = errorBase;
    }

    @Override
    public String getErrorCode() {
        return errorBase.getErrorCode();
    }

    @Override
    public int getStateCode() {
        return errorBase.getStateCode();
    }

    @Override
    public String getName() {
        return errorBase.getName();
    }
}

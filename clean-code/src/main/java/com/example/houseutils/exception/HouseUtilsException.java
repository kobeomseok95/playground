package com.example.houseutils.exception;

public class HouseUtilsException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public HouseUtilsException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMesssage());
    }

    public HouseUtilsException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode;
        this.message = customMessage;
    }
}

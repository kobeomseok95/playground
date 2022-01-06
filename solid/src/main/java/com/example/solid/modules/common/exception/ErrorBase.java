package com.example.solid.modules.common.exception;

public interface ErrorBase {

    String getErrorCode();
    int getStateCode();
    String getMessage();
    String getName();
}

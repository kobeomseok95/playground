package com.example.solid.modules.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessException(BusinessException e) {
        ErrorResponse errorResponse = ErrorResponse.of(e.getErrorBase());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

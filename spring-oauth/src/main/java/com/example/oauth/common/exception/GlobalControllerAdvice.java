package com.example.oauth.common.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> applicationException(ApplicationException e) {
        ErrorResponse response = ErrorResponse.of(e);
        return new ResponseEntity<>(response, e.getHttpStatus());
    }

    @Getter
    public static class ErrorResponse {

        private LocalDateTime time;
        private int status;
        private String message;
        private String code;

        public ErrorResponse(int status, String message, String code) {
            this.time = LocalDateTime.now();
            this.status = status;
            this.message = message;
            this.code = code;
        }

        public static ErrorResponse of (ApplicationException e) {
            return new ErrorResponse(e.getHttpStatus().value(), e.getMessage(), e.getErrorCode());
        }
    }
}

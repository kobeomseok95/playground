package com.example.logging.advice;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFoundException(UserNotFoundException e) {
        return ErrorResponse.of(e.getMessage());
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class ErrorResponse {
        private int code;
        private int status;
        private String message;
        private LocalDateTime time;

        public static ErrorResponse of(String message) {
            return ErrorResponse.builder()
                    .code(100)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message(message)
                    .time(LocalDateTime.now())
                    .build();
        }
    }
}

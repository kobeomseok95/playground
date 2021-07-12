package com.example.exceptionguide.error.advices;

import com.example.exceptionguide.error.errorCodes.ErrorCode;
import com.example.exceptionguide.error.exceptions.MemberNotFoundException;
import com.example.exceptionguide.error.exceptions.MemberNotLoginException;
import com.example.exceptionguide.error.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MemberAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> memberNotFoundAdvice(MemberNotFoundException e) {

        log.error("MemberNotFoundException!!! {}", e.getMessage());
        ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MemberNotLoginException.class)
    public ResponseEntity<ErrorResponse> memberNotLoginAdvice(MemberNotLoginException e) {

        log.error("MemberNotLoginException!!! {}", e.getMessage());
        ErrorResponse response = ErrorResponse.of(ErrorCode.NOT_LOGIN);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

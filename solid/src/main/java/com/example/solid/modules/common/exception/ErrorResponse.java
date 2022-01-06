package com.example.solid.modules.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class ErrorResponse {

    private String errorCode;
    private int stateCode;
    private LocalDateTime time;
    private String message;

    public static ErrorResponse of(ErrorBase errorBase) {
        return ErrorResponse.builder()
                .errorCode(errorBase.getErrorCode())
                .stateCode(errorBase.getStateCode())
                .time(LocalDateTime.now())
                .message(errorBase.getMessage())
                .build();
    }
}

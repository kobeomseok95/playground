package com.example.mongo.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DateRequest implements Serializable {

    private String name;
    @DateTimeFormat(pattern = "yyyyMMdd")
    private LocalDate date;
}

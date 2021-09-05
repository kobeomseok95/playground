package com.example.bulkquery.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class DateDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
}

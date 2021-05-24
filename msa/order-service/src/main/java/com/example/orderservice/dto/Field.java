package com.example.orderservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Field {

    private String type;
    private boolean optional;
    private String field;
}

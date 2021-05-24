package com.example.orderservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schema {

    private String type;
    private List<Field> fields;
    private boolean optional;
    private String name;
}

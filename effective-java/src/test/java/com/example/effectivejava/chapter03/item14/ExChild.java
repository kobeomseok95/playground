package com.example.effectivejava.chapter03.item14;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@EqualsAndHashCode(
        of = "commonFields",
        callSuper = false
)
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class ExChild extends ExParent{

    private Long id;
    private LocalDateTime createdDate;
    private CommonFields commonFields;
}

package com.example.effectivejava.chapter03.item14;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@EqualsAndHashCode(of = {"name", "age"})
@AllArgsConstructor(access = PROTECTED)
public class CommonFields {

    private String name;
    private int age;
}

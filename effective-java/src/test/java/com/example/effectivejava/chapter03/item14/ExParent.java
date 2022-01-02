package com.example.effectivejava.chapter03.item14;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"name", "age"})
@Getter
public abstract class ExParent {

    private String name;
    private int age;
}

package com.example.logging.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class User {

    private Long userId;
    private String name;
    private int age;

    public User(Long userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}

package com.example.logging.controller;

import com.example.logging.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    private String name;
    private int age;

    public User toEntity(Long id) {
        return User.builder()
                .userId(id)
                .name(name)
                .age(age)
                .build();
    }
}

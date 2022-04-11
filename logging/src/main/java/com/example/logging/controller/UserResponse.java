package com.example.logging.controller;

import com.example.logging.domain.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long userId;
    private String name;
    private int age;

    public static UserResponse of(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }
}

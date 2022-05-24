package com.example.monitoring.user.application.port.in.request;

import com.example.monitoring.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {

    private String name;
    private int age;

    public User createUser() {
        return User.builder()
                .name(name)
                .age(age)
                .build();
    }
}

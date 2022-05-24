package com.example.monitoring.user.adapter.port.in.request;

import com.example.monitoring.user.application.port.in.request.CreateUserRequestDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {

    private String name;
    private int age;

    public CreateUserRequestDto toRequestDto() {
        return CreateUserRequestDto.builder()
                .name(name)
                .age(age)
                .build();
    }
}

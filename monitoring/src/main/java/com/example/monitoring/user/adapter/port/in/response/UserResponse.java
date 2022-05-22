package com.example.monitoring.user.adapter.port.in.response;

import com.example.monitoring.user.application.port.in.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private int age;

    public static UserResponse from(UserResponseDto userResponseDto) {
        return UserResponse.builder()
                .id(userResponseDto.getId())
                .name(userResponseDto.getName())
                .age(userResponseDto.getAge())
                .build();
    }
}

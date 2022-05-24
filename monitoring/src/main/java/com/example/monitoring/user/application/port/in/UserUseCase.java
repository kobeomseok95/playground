package com.example.monitoring.user.application.port.in;

import com.example.monitoring.user.application.port.in.request.CreateUserRequestDto;
import com.example.monitoring.user.application.port.in.response.UserResponseDto;

public interface UserUseCase {

    UserResponseDto findById(Long userId);

    UserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
}

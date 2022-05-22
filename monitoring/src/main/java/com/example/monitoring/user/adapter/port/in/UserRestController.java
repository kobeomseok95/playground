package com.example.monitoring.user.adapter.port.in;

import com.example.monitoring.user.adapter.port.in.response.UserResponse;
import com.example.monitoring.user.application.port.in.UserUseCase;
import com.example.monitoring.user.application.port.in.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserUseCase userUseCase;

    @GetMapping("/api/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userUseCase.findById(userId);
        return UserResponse.from(userResponseDto);
    }
}

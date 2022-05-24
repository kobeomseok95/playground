package com.example.monitoring.user.adapter.port.in;

import com.example.monitoring.user.adapter.port.in.request.CreateUserRequest;
import com.example.monitoring.user.adapter.port.in.response.UserResponse;
import com.example.monitoring.user.application.port.in.UserUseCase;
import com.example.monitoring.user.application.port.in.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@RequestBody CreateUserRequest createUserRequest) {
        UserResponseDto responseDto = userUseCase.createUser(createUserRequest.toRequestDto());
        return UserResponse.from(responseDto);
    }
}

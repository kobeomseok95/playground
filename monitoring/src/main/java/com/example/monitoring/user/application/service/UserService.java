package com.example.monitoring.user.application.service;

import com.example.monitoring.user.application.port.in.UserUseCase;
import com.example.monitoring.user.application.port.in.response.UserResponseDto;
import com.example.monitoring.user.application.port.out.UserRepository;
import com.example.monitoring.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserService implements UserUseCase {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto findById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return UserResponseDto.from(user);
    }
}

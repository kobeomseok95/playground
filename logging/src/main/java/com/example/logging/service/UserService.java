package com.example.logging.service;

import com.example.logging.controller.CreateUserRequest;
import com.example.logging.controller.UserResponse;
import com.example.logging.domain.User;
import com.example.logging.repository.UserInMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserInMemoryRepository userRepository;

    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId);
        return UserResponse.of(user);
    }

    public void create(CreateUserRequest createUserRequest) {
        userRepository.save(createUserRequest);
    }
}

package com.example.logging.repository;

import com.example.logging.advice.UserNotFoundException;
import com.example.logging.controller.CreateUserRequest;
import com.example.logging.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserInMemoryRepository {

    private Long userId = 1L;
    private final Map<Long, User> userRepository = new HashMap<>();


    public User findById(Long userId) {
        if (userId == 404) {
            throw new RuntimeException("404번 회원은 조회가 안된다.");
        }
        User user = userRepository.get(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public void save(CreateUserRequest createUserRequest) {
        User user = createUserRequest.toEntity(userId++);
        userRepository.put(user.getUserId(), user);
    }
}

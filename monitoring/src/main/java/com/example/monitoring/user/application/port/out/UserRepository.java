package com.example.monitoring.user.application.port.out;

import com.example.monitoring.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long userId);
}

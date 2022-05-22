package com.example.monitoring.user.adapter.port.out;

import com.example.monitoring.user.application.port.out.UserRepository;
import com.example.monitoring.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
class UserInMemoryRepository implements UserRepository {

    private static final Map<Long, User> userMap = new HashMap<>();
    private static final Long autoIncrementId = 1L;

    @Override
    public Optional<User> findById(Long userId) {
        if (userMap.containsKey(userId)) {
            return Optional.of(userMap.get(userId));
        }
        return Optional.empty();
    }
}

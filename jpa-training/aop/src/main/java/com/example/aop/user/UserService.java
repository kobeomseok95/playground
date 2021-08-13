package com.example.aop.user;

import com.example.aop.aspect.GetUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public Info getUser(Long userId, Optional<User> user) {
        return Info.builder()
                .email(user.map(User::getEmail).orElse("Not Login"))
                .username(user.map(User::getName).orElse("Not Login"))
                .build();
    }
}

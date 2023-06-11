package com.example.demo.user.adapter.port.out.persistence;

import com.example.demo.user.application.port.out.SaveUserAdapter;
import com.example.demo.user.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

@Repository
@ActiveProfiles("test")
public class FakeSaveUserAdapter implements SaveUserAdapter {
    private Map<Long, User> userMap = new HashMap<>();
    @Override
    public User save(User user) {
        Long id = Integer.toUnsignedLong(userMap.keySet().size()) + 1;
        userMap.put(id, user);
        return User.builder()
                .id(id)
                .email(user.getEmail())
                .nickname(user.getNickname())
                .address(user.getAddress())
                .certificationCode(user.getCertificationCode())
                .userStatus(user.getUserStatus())
                .lastLoginAt(user.getLastLoginAt())
                .build();
    }

    public void clear() {
        this.userMap.clear();
    }
}

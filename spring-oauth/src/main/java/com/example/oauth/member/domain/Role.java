package com.example.oauth.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "사용자"),
    ADMIN("ROLE_ADMIN", "관리자"),
    ;

    private final String key;
    private final String title;

    public static Role getRole(String key) {
        return Arrays.stream(Role.values())
                .filter(role -> role.getKey().equals(key))
                .findAny()
                .orElseThrow();
    }
}

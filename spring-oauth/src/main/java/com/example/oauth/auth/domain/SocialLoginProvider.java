package com.example.oauth.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SocialLoginProvider {

    kakao("kakao", "카카오"),
    apple("apple", "애플"),
    ;

    private final String providerValue;
    private final String description;
}

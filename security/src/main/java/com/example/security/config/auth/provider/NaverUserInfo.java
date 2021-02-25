package com.example.security.config.auth.provider;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo{

    private final Map<String, Object> attributes;

    @Override
    public String getProviderId() {
        return (String)attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String)attributes.get("email");
    }

    @Override
    public String getName() {
        return (String)attributes.get("name");
    }
}

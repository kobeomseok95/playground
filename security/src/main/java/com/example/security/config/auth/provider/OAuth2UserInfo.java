package com.example.security.config.auth.provider;

public interface OAuth2UserInfo {

    String getProviderId();

    String getProvider();

    String getEmail();

    String getName();
}

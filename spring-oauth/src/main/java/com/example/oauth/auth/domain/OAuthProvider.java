package com.example.oauth.auth.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthProvider {

    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String tokenUri;
    private final String userInfoUri;

    @Builder
    public OAuthProvider(String clientId, String clientSecret, String redirectUri, String tokenUri, String userInfoUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.tokenUri = tokenUri;
        this.userInfoUri = userInfoUri;
    }

    public OAuthProvider(OAuthProperties.Registration registration, OAuthProperties.Provider provider) {
        this(registration.getClientId(), registration.getClientSecret(), registration.getRedirectUri(), provider.getTokenUri(), provider.getUserInfoUri());
    }
}

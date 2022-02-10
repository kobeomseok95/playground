package com.example.oauth.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserProfileResponse {
    private final String oauthId;
    private final String email;
    private final String name;
    private final String imageUrl;

    @Builder
    public UserProfileResponse(String oauthId, String email, String name, String imageUrl) {
        this.oauthId = oauthId;
        this.email = email;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}

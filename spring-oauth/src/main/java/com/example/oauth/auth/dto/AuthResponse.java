package com.example.oauth.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponse {

    private String tokenType = "Bearer";
    private String accessToken;
    private String refreshToken;

    private AuthResponse(String accessToken,String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static AuthResponse of(String accessToken, String refreshToken){
        return new AuthResponse(accessToken,refreshToken);
    }
}

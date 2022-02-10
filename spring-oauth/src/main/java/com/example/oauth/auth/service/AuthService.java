package com.example.oauth.auth.service;

import com.example.oauth.auth.domain.SocialLoginProvider;
import com.example.oauth.auth.dto.response.AuthResponse;
import com.example.oauth.member.domain.Member;

public interface AuthService {

    AuthResponse login(SocialLoginProvider provider, String code);

    void logout(String accessToken, String refreshToken);

    AuthResponse reissue(Member member);
}

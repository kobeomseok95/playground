package com.example.oauth.auth.service;

import com.example.oauth.auth.domain.LogoutAccessToken;
import com.example.oauth.auth.domain.LogoutRefreshToken;
import com.example.oauth.auth.domain.repository.LogoutAccessTokenRepository;
import com.example.oauth.auth.domain.repository.LogoutRefreshTokenRepository;
import com.example.oauth.auth.dto.AuthResponse;
import com.example.oauth.auth.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final TokenProvider tokenProvider;
    private final LogoutAccessTokenRepository logoutAccessTokenRepository;
    private final LogoutRefreshTokenRepository logoutRefreshTokenRepository;

    public void logout(String accessToken, String refreshToken) {
        String removedTypeAccessToken = getRemovedBearerType(accessToken);
        String removedTypeRefreshToken = getRemovedBearerType(refreshToken);

        LogoutAccessToken logoutAccessToken
                = LogoutAccessToken.of(removedTypeAccessToken,
                tokenProvider.getRemainingMilliSecondsFromToken(removedTypeAccessToken));
        logoutAccessTokenRepository.save(logoutAccessToken);

        LogoutRefreshToken logoutRefreshToken
                = LogoutRefreshToken.of(removedTypeRefreshToken,
                tokenProvider.getRemainingMilliSecondsFromToken(removedTypeRefreshToken));
        logoutRefreshTokenRepository.save(logoutRefreshToken);
    }

    private String getRemovedBearerType(String token){
        return token.substring(7);
    }

    public AuthResponse reissue() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = tokenProvider.createAccessToken(authentication);
        String refreshToken = tokenProvider.createRefreshToken(authentication);
        return AuthResponse.of(accessToken, refreshToken);
    }
}

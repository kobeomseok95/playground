package com.example.oauth.auth.service;

import com.example.oauth.auth.domain.*;
import com.example.oauth.auth.domain.repository.LogoutAccessTokenRepository;
import com.example.oauth.auth.domain.repository.LogoutRefreshTokenRepository;
import com.example.oauth.auth.domain.repository.ProviderRepository;
import com.example.oauth.auth.dto.response.AuthResponse;
import com.example.oauth.auth.dto.response.OAuthTokenResponse;
import com.example.oauth.auth.dto.response.UserProfileResponse;
import com.example.oauth.auth.jwt.TokenProvider;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import com.example.oauth.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final ProviderRepository providerRepository;
    private final TokenProvider tokenProvider;
    private final LogoutAccessTokenRepository logoutAccessTokenRepository;
    private final LogoutRefreshTokenRepository logoutRefreshTokenRepository;
    private final MemberRepository memberRepository;

    public AuthResponse login(SocialLoginProvider provider, String code) {
        OAuthProvider oAuthProvider = providerRepository.findByProviderName(provider.getProviderValue());
        OAuthTokenResponse oAuthAccessToken = getOAuthAccessToken(oAuthProvider, code);
        UserProfileResponse userProfile = getUserProfile(provider.getProviderValue(), oAuthAccessToken, oAuthProvider);
        Member member = saveOrUpdate(userProfile, provider.getProviderValue());
        MemberPrincipal principal = MemberPrincipal.from(member);
        String accessToken = tokenProvider.createAccessToken(member.getEmail());
        String refreshToken = tokenProvider.createRefreshToken(member.getEmail());
        return AuthResponse.of(accessToken, refreshToken);
    }

    private OAuthTokenResponse getOAuthAccessToken(OAuthProvider oAuthProvider, String code) {
        return WebClient.create()
                .post()
                .uri(oAuthProvider.getTokenUri())
                .headers(header -> {
                    header.setBasicAuth(oAuthProvider.getClientId(), oAuthProvider.getClientSecret());
                    header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                    header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                    header.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8));
                })
                .bodyValue(tokenRequest(oAuthProvider, code))
                .retrieve()
                .bodyToMono(OAuthTokenResponse.class)
                .block();
    }

    private MultiValueMap<String, String> tokenRequest(OAuthProvider oAuthProvider, String code) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "authorization_code");
        formData.add("client_id", oAuthProvider.getClientId());
        formData.add("redirect_uri", oAuthProvider.getRedirectUri());
        formData.add("code", code);
        formData.add("client_secret", oAuthProvider.getClientSecret());
        return formData;
    }

    private UserProfileResponse getUserProfile(String providerName, OAuthTokenResponse oAuthTokenResponse, OAuthProvider provider) {
        Map<String, Object> userAttributes = getUserAttributes(provider, oAuthTokenResponse);
        return OAuthAttributesEnum.extract(providerName, userAttributes);
    }

    private Map<String, Object> getUserAttributes(OAuthProvider provider, OAuthTokenResponse oAuthTokenResponse) {
        return WebClient.create()
                .get()
                .uri(provider.getUserInfoUri())
                .headers(header -> header.setBearerAuth(oAuthTokenResponse.getAccessToken()))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() { })
                .block();
    }

    private Member saveOrUpdate(UserProfileResponse userProfile, String providerName) {
        Optional<Member> memberOptional = memberRepository.findByEmailAndSocial(userProfile.getEmail(), true);
        Member member;
        if (memberOptional.isPresent()) {
            member = memberOptional.get();
            member.update(userProfile.getName(), userProfile.getImageUrl());
        }
        else {
            member =  memberRepository.save(Member.builder()
                    .email(userProfile.getEmail())
                    .role(Role.USER)
                    .social(true)
                    .picture(userProfile.getImageUrl())
                    .name(userProfile.getName())
                    .authProvider(AuthProvider.valueOf(providerName))
                    .build());
        }
        return member;
    }

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

    public AuthResponse reissue(Member member) {
        String accessToken = tokenProvider.createAccessToken(String.valueOf(member.getEmail()));
        String refreshToken = tokenProvider.createRefreshToken(String.valueOf(member.getEmail()));
        return AuthResponse.of(accessToken, refreshToken);
    }
}

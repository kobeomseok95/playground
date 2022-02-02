package com.example.oauth;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.auth.domain.repository.LogoutAccessTokenRepository;
import com.example.oauth.auth.domain.repository.LogoutRefreshTokenRepository;
import com.example.oauth.auth.handler.LoginFailureHandler;
import com.example.oauth.auth.handler.LoginSuccessHandler;
import com.example.oauth.auth.handler.RestAccessDeniedHandler;
import com.example.oauth.auth.handler.RestAuthenticationEntryPoint;
import com.example.oauth.auth.jwt.TokenProvider;
import com.example.oauth.auth.service.AuthService;
import com.example.oauth.auth.service.CustomOAuth2Service;
import com.example.oauth.auth.service.CustomUserDetailsService;
import com.example.oauth.common.exception.auth.TokenAuthenticationFilterException;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public abstract class SecuritySupport {

    @MockBean protected LoginFailureHandler loginFailureHandler;
    @MockBean protected LoginSuccessHandler loginSuccessHandler;
    @MockBean protected RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @MockBean protected RestAccessDeniedHandler restAccessDeniedHandler;
    @MockBean protected CustomOAuth2Service customOAuth2Service;
    @MockBean protected TokenProvider tokenProvider;
    @MockBean protected CustomUserDetailsService customUserDetailsService;
    @MockBean protected LogoutAccessTokenRepository logoutAccessTokenRepository;
    @MockBean protected LogoutRefreshTokenRepository logoutRefreshTokenRepository;
    @MockBean protected AuthService authService;

    protected void securityUserMockSetting() {
        Member member = createMember();
        when(logoutAccessTokenRepository.existsById(any())).thenReturn(false);
        when(logoutRefreshTokenRepository.existsById(any())).thenReturn(false);
        when(tokenProvider.validateToken(any())).thenReturn(true);
        when(tokenProvider.getUserEmail(any())).thenReturn(member.getEmail());
        when(tokenProvider.getAuthProvider(any())).thenReturn(AuthProvider.kakao);
        when(customUserDetailsService.loadTokenUserByUsername(anyString(), any())).thenReturn(MemberPrincipal.from(createMember()));
    }

    private Member createMember() {
        return Member.builder()
                .id(1L)
                .email("kobumssh@naver.com")
                .name("테스트")
                .role(Role.USER)
                .social(true)
                .authProvider(AuthProvider.kakao)
                .picture("test_image_url.jpg")
                .password("test")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
    }

    protected void securityInvalidTokenSetting() {
        when(tokenProvider.validateToken(any()))
                .thenThrow(TokenAuthenticationFilterException.class);
    }

    protected String getMockAccessToken() {
        Member member = createMember();
        Date now = new Date();
        return Jwts.builder()
                .setSubject(member.getEmail())
                .claim("authProvider", member.getAuthProvider())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 100000))
                .signWith(SignatureAlgorithm.HS512, "test")
                .compact();
    }

    protected String getMockRefreshToken() {
        Member member = createMember();
        Date now = new Date();
        return Jwts.builder()
                .setSubject(member.getEmail())
                .claim("authProvider", member.getAuthProvider())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 1000000))
                .signWith(SignatureAlgorithm.HS512, "test")
                .compact();
    }
}

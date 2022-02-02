package com.example.oauth;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.auth.domain.repository.LogoutAccessTokenRepository;
import com.example.oauth.auth.domain.repository.LogoutRefreshTokenRepository;
import com.example.oauth.auth.handler.LoginFailureHandler;
import com.example.oauth.auth.handler.LoginSuccessHandler;
import com.example.oauth.auth.handler.RestAccessDeniedHandler;
import com.example.oauth.auth.handler.RestAuthenticationEntryPoint;
import com.example.oauth.auth.jwt.TokenProvider;
import com.example.oauth.auth.service.CustomOAuth2Service;
import com.example.oauth.auth.service.CustomUserDetailsService;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public abstract class SecuritySupport {

    @MockBean LoginFailureHandler loginFailureHandler;
    @MockBean LoginSuccessHandler loginSuccessHandler;
    @MockBean RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @MockBean RestAccessDeniedHandler restAccessDeniedHandler;
    @MockBean CustomOAuth2Service customOAuth2Service;
    @MockBean TokenProvider tokenProvider;
    @MockBean CustomUserDetailsService customUserDetailsService;
    @MockBean LogoutAccessTokenRepository logoutAccessTokenRepository;
    @MockBean LogoutRefreshTokenRepository logoutRefreshTokenRepository;

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
                .build();
    }
}

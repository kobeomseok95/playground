package com.example.oauth.support;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockJwtSecurityContextFactory implements WithSecurityContextFactory<WithMockJwt> {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public SecurityContext createSecurityContext(WithMockJwt annotation) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Member mockMember = Member.builder()
                .id(annotation.id())
                .email(annotation.username())
                .name("test")
                .password(passwordEncoder.encode(annotation.password()))
                .role(Role.getRole(annotation.role()))
                .social(true)
                .authProvider(AuthProvider.kakao)
                .build();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        MemberPrincipal.from(mockMember),
                        mockMember.getPassword(),
                        AuthorityUtils.createAuthorityList(annotation.role()));
        context.setAuthentication(authentication);
        return context;
    }
}

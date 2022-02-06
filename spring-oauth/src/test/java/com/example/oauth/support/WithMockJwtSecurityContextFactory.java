package com.example.oauth.support;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockJwtSecurityContextFactory implements WithSecurityContextFactory<WithMockJwt> {

    @Override
    public SecurityContext createSecurityContext(WithMockJwt annotation) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Member mockMember = Member.builder()
                .id(annotation.id())
                .email(annotation.username())
                .role(Role.getRole(annotation.role()))
                .build();

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(MemberPrincipal.from(mockMember), null);
        context.setAuthentication(authentication);
        return context;
    }
}

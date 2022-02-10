package com.example.oauth.auth.domain;

import com.example.oauth.member.domain.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
public class MemberPrincipal implements UserDetails {

    private Member member;
    private Map<String, Object> attributes;

    private MemberPrincipal(Member member) {
        this.member = member;
    }

    public static MemberPrincipal of(Member member, Map<String, Object> attributes) {
        MemberPrincipal memberPrincipal = MemberPrincipal.from(member);
        memberPrincipal.setAttributes(attributes);
        return memberPrincipal;
    }

    public static MemberPrincipal from(Member member) {
        return new MemberPrincipal(member);
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(member.getRoleKey()));
    }

//    @Override
//    public String getName() {
//        return member.getName();
//    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

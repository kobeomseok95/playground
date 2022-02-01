package com.example.oauth.auth.service;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmailAndSocial(username, false)
                .orElseThrow(() -> new UsernameNotFoundException("check email or social"));
        return MemberPrincipal.from(member);
    }

    public UserDetails loadTokenUserByUsername(String username, AuthProvider authProvider) throws UsernameNotFoundException{
        Member member = memberRepository.findByEmailAndAuthProvider(username, authProvider)
                .orElseThrow(() -> new UsernameNotFoundException("check email or social"));

        return MemberPrincipal.from(member);
    }
}

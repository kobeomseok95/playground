package com.example.oauth.auth.service;

import com.example.oauth.auth.domain.MemberPrincipal;
import com.example.oauth.auth.dto.OAuthAttributes;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomOAuth2Service extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        Member member = saveOrUpdate(attributes);
        return MemberPrincipal.of(member, attributes.getAttributes());
    }

    private Member saveOrUpdate(OAuthAttributes attributes) {
        Optional<Member> memberOptional = memberRepository.findByEmailAndSocial(attributes.getEmail(), true);
        Member member;
        if (memberOptional.isPresent()) {
            member = memberOptional.get();
            member.update(attributes.getName(), attributes.getProfileImage());
        }
        else {
            member =  memberRepository.save(attributes.toMemberEntity());
        }
        return member;
    }
}

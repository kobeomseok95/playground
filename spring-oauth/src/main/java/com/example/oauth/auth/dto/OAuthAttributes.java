package com.example.oauth.auth.dto;

import com.example.oauth.common.exception.auth.NotSupportRegistrationIdException;
import com.example.oauth.member.domain.AuthProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Map;

@Getter
@AllArgsConstructor
@Builder
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String profileImage;
    private AuthProvider authProvider;

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String,Object> attributes){

        switch (registrationId){
            // TODO apple 로그인 추가
            case "kakao":
                return ofKakao("id",attributes);
            default:
                throw new NotSupportRegistrationIdException();
        }
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String,Object> attributes) {
        Map<String, Object> account = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) account.get("profile");

        return OAuthAttributes.builder()
                .name((String) profile.get("nickname"))
                .email((String) account.get("email"))
                .profileImage((String) profile.get("profile_image_url"))
                .attributes(account)
                .nameAttributeKey(userNameAttributeName)
                .authProvider(AuthProvider.kakao)
                .build();
    }

    public Member toMemberEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .picture(StringUtils.hasText(profileImage) ? profileImage : null)
                .social(true)
                .authProvider(authProvider)
                .role(Role.USER)
                .build();
    }
}

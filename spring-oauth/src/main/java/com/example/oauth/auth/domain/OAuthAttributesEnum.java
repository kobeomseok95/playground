package com.example.oauth.auth.domain;

import com.example.oauth.auth.dto.response.UserProfileResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OAuthAttributesEnum {

    KAKAO("kakao") {
        @Override
        public UserProfileResponse of(Map<String, Object> attributes) {
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            return UserProfileResponse.builder()
                    .oauthId(String.valueOf(attributes.get("id")))
                    .email((String) kakaoAccount.get("email"))
                    .name((String) properties.get("nickname"))
                    .imageUrl((String) properties.get("profile_image"))
                    .build();
        }
    };

    private final String providerName;
    public abstract UserProfileResponse of(Map<String, Object> attributes);

    public static UserProfileResponse extract(String providerName, Map<String, Object> userAttributes) {
        return Arrays.stream(values())
                .filter(provider -> providerName.equals(provider.providerName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of(userAttributes);
    }
}

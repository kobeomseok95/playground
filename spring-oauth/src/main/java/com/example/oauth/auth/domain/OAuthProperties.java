package com.example.oauth.auth.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ConfigurationProperties("spring.security.oauth2.client")
public class OAuthProperties {

    private final Map<String, Registration> registration = new HashMap<>();
    private final Map<String, Provider> provider = new HashMap<>();

    @Getter
    @Setter
    public static class Registration {
        private String clientId;
        private String clientSecret;
        private String redirectUri;
        private List<String> scope;
        private String clientName;
    }

    @Getter
    @Setter
    public static class Provider {
        private String authorizationUri;
        private String tokenUri;
        private String userInfoUri;
        private String userNameAttribute;
    }
}

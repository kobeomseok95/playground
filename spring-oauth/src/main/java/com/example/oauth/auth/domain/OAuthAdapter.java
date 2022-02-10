package com.example.oauth.auth.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuthAdapter {

    public static Map<String, OAuthProvider> getOAuthProviders(OAuthProperties properties) {
        Map<String, OAuthProvider> oAuthProviderMap = new HashMap<>();
        properties.getRegistration().forEach((key, value) ->
                oAuthProviderMap.put(key, new OAuthProvider(value, properties.getProvider().get(key))));
        return oAuthProviderMap;
    }
}

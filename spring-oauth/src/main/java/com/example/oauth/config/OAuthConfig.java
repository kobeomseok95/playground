package com.example.oauth.config;

import com.example.oauth.auth.domain.OAuthAdapter;
import com.example.oauth.auth.domain.OAuthProperties;
import com.example.oauth.auth.domain.OAuthProvider;
import com.example.oauth.auth.domain.repository.InMemoryProviderRepository;
import com.example.oauth.auth.domain.repository.ProviderRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties(OAuthProperties.class)
public class OAuthConfig {

    private final OAuthProperties properties;

    public OAuthConfig(OAuthProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ProviderRepository providerRepository() {
        Map<String, OAuthProvider> oAuthProviders = OAuthAdapter.getOAuthProviders(properties);
        return new InMemoryProviderRepository(oAuthProviders);
    }
}

package com.example.oauth.auth.domain.repository;

import com.example.oauth.auth.domain.OAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class InMemoryProviderRepository implements ProviderRepository{

    private final Map<String, OAuthProvider> providers;

    @Override
    public OAuthProvider findByProviderName(String name) {
        return providers.get(name);
    }
}

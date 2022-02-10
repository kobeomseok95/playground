package com.example.oauth.auth.domain.repository;

import com.example.oauth.auth.domain.OAuthProvider;

public interface ProviderRepository {

    OAuthProvider findByProviderName(String name);
}

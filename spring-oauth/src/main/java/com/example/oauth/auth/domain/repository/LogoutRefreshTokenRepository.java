package com.example.oauth.auth.domain.repository;

import com.example.oauth.auth.domain.LogoutRefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface LogoutRefreshTokenRepository extends CrudRepository<LogoutRefreshToken, String> {

}

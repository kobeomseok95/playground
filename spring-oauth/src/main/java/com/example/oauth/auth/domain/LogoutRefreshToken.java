package com.example.oauth.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Id;
import java.util.concurrent.TimeUnit;

@Getter
@RedisHash("logoutRefreshToken")
@AllArgsConstructor
@Builder
public class LogoutRefreshToken {

    @Id
    private String id;

    @TimeToLive(unit = TimeUnit.MILLISECONDS)
    private long expiration;

    public static LogoutRefreshToken of (String accessToken, Long expiration){
        return LogoutRefreshToken.builder()
                .id(accessToken)
                .expiration(expiration)
                .build();
    }
}

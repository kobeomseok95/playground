package tutorial.redis.example.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum JwtExpirationEnums {

    ACCESS_TOKEN_EXPIRATION_TIME("JWT 만료 시간 / 10초", 1000L * 10),
    REFRESH_TOKEN_EXPIRATION_TIME("Refresh 토큰 만료 시간 / 60초", 1000L * 60);

    private String description;
    private Long value;
}

package tutorial.redis.example.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum JwtHeaderUtilEnums {

    ACCESS_TOKEN_NAME("JWT 만료 시간 / 30초", "accessToken"),
    REFRESH_TOKEN_NAME("Refresh 토큰 만료 시간 / 60초", "refreshToken"),
    GRANT_TYPE("JWT 타입 / Bearer ", "Bearer ");

    private String description;
    private String value;
}

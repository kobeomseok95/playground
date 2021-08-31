package com.example.redisexample.vo;

import com.example.redisexample.dto.TermsDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@RedisHash("person")
public class PersonRedis {

    @org.springframework.data.annotation.Id
    private String Id;
    private String name;
    private String address;
    private String nickname;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

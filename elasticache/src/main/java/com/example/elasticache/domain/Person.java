package com.example.elasticache.domain;

import com.example.elasticache.controller.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "people", timeToLive = 60)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDateTime createdDate;

    public static Person of(PersonDto personDto) {
        return Person.builder()
                .name(personDto.getName())
                .age(personDto.getAge())
                .build();
    }
}

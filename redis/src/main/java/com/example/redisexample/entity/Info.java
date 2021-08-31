package com.example.redisexample.entity;

import lombok.*;

import javax.persistence.*;

@Embeddable @Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED) @Builder
public class Info {

    private String name;
    private String nickname;
}

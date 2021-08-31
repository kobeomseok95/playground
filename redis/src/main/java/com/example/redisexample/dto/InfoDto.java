package com.example.redisexample.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class InfoDto {

    private String name;
    private String address;
}

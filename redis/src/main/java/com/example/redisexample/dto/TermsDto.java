package com.example.redisexample.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TermsDto {

    private boolean one;
    private boolean two;
    private boolean three;
}

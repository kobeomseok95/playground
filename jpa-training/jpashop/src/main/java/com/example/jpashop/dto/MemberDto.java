package com.example.jpashop.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberDto {

    private String name;
    private String city;
    private String street;
    private String zipcode;
}

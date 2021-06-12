package com.example.jpashop.dto;

import lombok.*;

import java.util.List;

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
    private List<OrderDto> orders;
}

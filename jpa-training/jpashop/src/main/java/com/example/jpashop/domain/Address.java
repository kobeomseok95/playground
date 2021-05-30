package com.example.jpashop.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
// 생성자를 protected로 막고, setter를 비활성화시켜
// 불변객체임을 설정해두기
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String city;
    private String street;
    private String zipcode;
}

package com.example.redisexample.entity;

import com.example.redisexample.dto.TermsDto;
import com.example.redisexample.vo.PersonRedis;
import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long Id;
    private String name;
    private String address;
    private String nickname;
    private boolean checkOne;
    private boolean checkTwo;
    private boolean checkThree;

    public static Person create(PersonRedis personRedis, TermsDto termsDto) {
        Person person = build(personRedis);
        person.setTerms(termsDto);
        return person;
    }

    private static Person build(PersonRedis personRedis) {
        return Person.builder()
                .name(personRedis.getName())
                .address(personRedis.getAddress())
                .nickname(personRedis.getNickname())
                .build();
    }

    private void setTerms (TermsDto termsDto) {
        this.checkOne = termsDto.isOne();
        this.checkTwo = termsDto.isTwo();
        this.checkThree = termsDto.isThree();
    }
}

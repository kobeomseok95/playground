package com.demo.querydslexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@NoArgsConstructor(access = PROTECTED) @AllArgsConstructor(access = PROTECTED)
@Builder
public class Member {

    /**
     *  TODO 만약 멤버가 Article, Address를 참조해야한다고 가정했을 때 일급 컬렉션으로
     *      리팩토링 해보기
     */
    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @Embedded
    private Articles articles;

    @Embedded
    private Addresses addresses;

    public static Member of(String username) {
        return Member.builder()
                .username(username)
                .build();
    }
}

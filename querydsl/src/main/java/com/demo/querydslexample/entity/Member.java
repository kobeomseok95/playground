package com.demo.querydslexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@NoArgsConstructor(access = PROTECTED) @AllArgsConstructor(access = PROTECTED)
@Builder
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    public static Member of(String username) {
        return Member.builder()
                .username(username)
                .build();
    }
}

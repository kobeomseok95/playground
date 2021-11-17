package com.demo.querydslexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@NoArgsConstructor(access = PROTECTED) @AllArgsConstructor(access = PROTECTED)
@Builder
public class Address {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ADDRESS_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String fullAddress;

    public static Address of(Member member, String fullAddress) {
        return Address.builder()
                .member(member)
                .fullAddress(fullAddress)
                .build();
    }
}

package com.example.flyway.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 100)
    private String intro;
}

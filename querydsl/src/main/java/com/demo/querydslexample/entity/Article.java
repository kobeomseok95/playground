package com.demo.querydslexample.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@NoArgsConstructor(access = PROTECTED) @AllArgsConstructor(access = PROTECTED)
@Builder
public class Article {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ARTICLE_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String title;

    public static Article of(Member member, String title) {
        return Article.builder()
                .member(member)
                .title(title)
                .build();
    }
}

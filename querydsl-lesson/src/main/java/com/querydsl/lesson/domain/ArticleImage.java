package com.querydsl.lesson.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class ArticleImage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARTICLE_IMAGE_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    private String name;

    private String url;

    private int orders;
}

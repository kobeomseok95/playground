package com.querydsl.lesson.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARTICLE_COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    private String contents;
}

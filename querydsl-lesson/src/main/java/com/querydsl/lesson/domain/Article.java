package com.querydsl.lesson.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @OneToMany(mappedBy = "article")
    @Builder.Default
    private List<ArticleImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    @Builder.Default
    private List<ArticleComment> comments = new ArrayList<>();

    private String title;

    private String contents;
}

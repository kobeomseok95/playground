package com.example.bulkquery.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class FavoriteArticle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "FAVORITE_ARTICLE_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
}

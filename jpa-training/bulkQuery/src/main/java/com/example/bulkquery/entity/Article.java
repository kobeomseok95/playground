package com.example.bulkquery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ARTICLE_ID")
    private Long id;
    private String title;

    @Builder.Default
    @OneToMany(mappedBy = "article", orphanRemoval = true)
    private List<FavoriteArticle> favoriteMemberList = new ArrayList<>();
}

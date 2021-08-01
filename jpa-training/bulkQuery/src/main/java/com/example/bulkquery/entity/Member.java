package com.example.bulkquery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FavoriteArticle> favoriteArticleList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY/*, mappedBy = "member"*/)
    private Address address;

    public void addFavoriteArticleList(List<Article> favoriteArticleList) {
        List<FavoriteArticle> addFavoriteArticleList = favoriteArticleList.stream()
                .map(article -> FavoriteArticle.builder().article(article)
                        .member(this).build())
                .collect(toList());

        this.getFavoriteArticleList().addAll(addFavoriteArticleList);
    }
}

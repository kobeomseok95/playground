package com.example.bulkquery.entity;

import com.example.bulkquery.controller.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ARTICLE_ID")
    private Long id;

    private String title;

    public static Article of(ArticleDto articleDto) {
        return Article.builder()
                .title(articleDto.getTitle())
                .build();
    }
}

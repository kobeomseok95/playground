package com.example.ngrinder.domain;

import com.example.ngrinder.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "ARTICLE_ID")
    private Long id;

    private String title;

    private String author;

    public void set(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.author = articleDto.getAuthor();
    }
}

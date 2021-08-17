package com.example.mongo.dto;


import com.example.mongo.document.Article;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    private String _id;
    private String title;
    private String content;

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                ._id(article.get_id())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }
}

package com.example.mongo.document;

import com.example.mongo.dto.ArticleDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("article")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    @Id
    private String _id;
    private String title;
    private String content;

    public static Article of(ArticleDto articleDto) {
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();
    }

    public void modify(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.content = articleDto.getContent();
    }
}

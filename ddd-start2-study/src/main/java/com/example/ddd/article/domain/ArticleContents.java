package com.example.ddd.article.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
public class ArticleContents {

    private String title;
    private String contents;
    private LocalDateTime createdDate;
}

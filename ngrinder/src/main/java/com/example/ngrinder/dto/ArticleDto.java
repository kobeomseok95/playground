package com.example.ngrinder.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    private String title;

    private String author;
}

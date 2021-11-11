package com.example.bulkquery.entity;

import com.example.bulkquery.controller.dto.CommentDtoList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    private String comment;

    public static List<Comment> of(Article article, List<CommentDtoList.CommentDto> comments) {
        return comments.stream()
                .map(commentDto -> Comment.of(article, commentDto))
                .collect(toList());
    }

    private static Comment of(Article article, CommentDtoList.CommentDto commentDto) {
        return Comment.builder()
                .article(article)
                .comment(commentDto.getComment())
                .build();
    }
}

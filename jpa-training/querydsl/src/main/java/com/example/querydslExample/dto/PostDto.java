package com.example.querydslExample.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @Builder
public class PostDto {

    private String title;
    private Set<CommentDto> commentList = new LinkedHashSet<>();

    @QueryProjection
    public PostDto(String title, Set<CommentDto> commentList) {
        this.title = title;
        this.commentList = commentList;
    }

    @Getter @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED) @Builder
    public static class CommentDto {
        private Long commentId;
        private String text;

        @QueryProjection
        public CommentDto(Long commentId, String text) {
            this.commentId = commentId;
            this.text = text;
        }
    }
}

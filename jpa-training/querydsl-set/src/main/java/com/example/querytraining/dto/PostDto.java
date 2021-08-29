package com.example.querytraining.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
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
        private int order;
        private String text;

        @QueryProjection
        public CommentDto(int order, String text) {
            this.order = order;
            this.text = text;
        }
    }
}

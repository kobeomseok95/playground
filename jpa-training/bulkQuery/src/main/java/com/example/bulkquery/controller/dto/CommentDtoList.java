package com.example.bulkquery.controller.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDtoList {

    private List<CommentDto> comments;

    @Getter @Setter
    public static class CommentDto {
        private String comment;
    }
}

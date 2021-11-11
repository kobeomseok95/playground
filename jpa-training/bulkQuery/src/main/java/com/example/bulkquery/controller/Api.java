package com.example.bulkquery.controller;

import com.example.bulkquery.controller.dto.ArticleDto;
import com.example.bulkquery.controller.dto.CommentDtoList;
import com.example.bulkquery.service.ArticleService;
import com.example.bulkquery.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Api {

    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping("/articles")
    public String article(@RequestBody ArticleDto articleDto) {
        articleService.post(articleDto);
        return "ok";
    }

    @PostMapping("/articles/{articleId}/comments")
    public String comments(@PathVariable Long articleId,
                                        @RequestBody CommentDtoList commentDtoList) {
        commentService.post(articleId, commentDtoList);
        return "ok";
    }
}

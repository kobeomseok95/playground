package com.example.mongo.controller;

import com.example.mongo.dto.ArticleDto;
import com.example.mongo.dto.DateRequest;
import com.example.mongo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleControllerApi {

    private final ArticleService articleService;

    @PostMapping("")
    public String postArticle(@RequestBody ArticleDto articleDto) {
        articleService.postArticle(articleDto);
        return "Create";
    }

    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        return ResponseEntity.ok().body(articleService.getArticles());
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable String articleId) {
        return ResponseEntity.ok().body(articleService.getArticle(articleId));
    }

    @PatchMapping("/{articleId}")
    public String modifyArticle(@PathVariable String articleId, @RequestBody ArticleDto articleDto) {
        articleService.modifyArticle(articleId, articleDto);
        return "Update";
    }

    @DeleteMapping("/{articleId}")
    public String modifyArticle(@PathVariable String articleId) {
        articleService.deleteArticle(articleId);
        return "Delete";
    }

    @PostMapping("/date")
    public String date(@RequestBody DateRequest dateRequest) {

        return "checkDate";
    }

    @GetMapping("/date")
    public String dateGet(DateRequest dateRequest) {

        return "checkDate";
    }
}

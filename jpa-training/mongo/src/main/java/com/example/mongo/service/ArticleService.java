package com.example.mongo.service;

import com.example.mongo.document.Article;
import com.example.mongo.dto.ArticleDto;
import com.example.mongo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void postArticle(ArticleDto articleDto) {
        articleRepository.insert(Article.of(articleDto));
    }

    public List<ArticleDto> getArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles
                .stream()
                .map(ArticleDto::of)
                .collect(toList());
    }

    public ArticleDto getArticle(String articleId) {
        return ArticleDto.of(articleRepository.findById(articleId).orElseThrow());
    }

    public void modifyArticle(String articleId, ArticleDto articleDto) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        article.modify(articleDto);
        articleRepository.save(article);
    }

    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }
}

package com.example.bulkquery.service;

import com.example.bulkquery.controller.dto.ArticleDto;
import com.example.bulkquery.entity.Article;
import com.example.bulkquery.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void post(ArticleDto articleDto) {
        articleRepository.save(Article.of(articleDto));
    }
}

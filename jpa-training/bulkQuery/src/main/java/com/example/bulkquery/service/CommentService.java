package com.example.bulkquery.service;

import com.example.bulkquery.controller.dto.CommentDtoList;
import com.example.bulkquery.entity.Article;
import com.example.bulkquery.entity.Comment;
import com.example.bulkquery.repository.ArticleRepository;
import com.example.bulkquery.repository.CommentJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentJdbcRepository commentJdbcRepository;

    public void post(Long articleId, CommentDtoList commentDtoList) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        List<Comment> commentList = Comment.of(article, commentDtoList.getComments());
        commentJdbcRepository.saveAll(article, commentList);
    }
}

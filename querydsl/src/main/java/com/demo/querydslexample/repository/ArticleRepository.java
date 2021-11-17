package com.demo.querydslexample.repository;

import com.demo.querydslexample.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

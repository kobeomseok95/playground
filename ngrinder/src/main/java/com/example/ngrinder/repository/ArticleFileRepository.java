package com.example.ngrinder.repository;

import com.example.ngrinder.domain.ArticleFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleFileRepository extends JpaRepository<ArticleFile, Long> {

    void deleteByArticleId(Long articleId);
}

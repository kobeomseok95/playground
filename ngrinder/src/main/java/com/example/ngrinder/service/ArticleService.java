package com.example.ngrinder.service;

import com.example.ngrinder.domain.Article;
import com.example.ngrinder.domain.ArticleFile;
import com.example.ngrinder.dto.ArticleDto;
import com.example.ngrinder.repository.ArticleFileRepository;
import com.example.ngrinder.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleFileRepository articleFileRepository;

    public void post(ArticleDto articleDto) {
        articleRepository.save(Article.builder()
                .author(articleDto.getAuthor())
                .title(articleDto.getTitle())
                .build());
    }

    public ArticleDto get(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();
        return ArticleDto.builder()
                .author(article.getAuthor())
                .title(article.getTitle())
                .build();
    }

    public void put(Long id, ArticleDto articleDto) {
        Article article = articleRepository.findById(id).orElseThrow();
        article.set(articleDto);
    }

    public void delete(Long id) {
        articleFileRepository.deleteByArticleId(id);
        articleRepository.deleteById(id);
    }

    public void postImage(List<MultipartFile> files, ArticleDto articleDto) {
        Article article = Article.builder()
                .author(articleDto.getAuthor())
                .title(articleDto.getTitle())
                .build();
        articleRepository.save(article);

        List<ArticleFile> articleFileList = files.stream().map(file ->
                ArticleFile.builder()
                        .article(article)
                        .fileName(file.getOriginalFilename())
                        .build()).collect(toList());
        articleFileRepository.saveAll(articleFileList);
    }
}

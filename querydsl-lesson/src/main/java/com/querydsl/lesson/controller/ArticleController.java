package com.querydsl.lesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/{articleId}")
public class ArticleController {

//    엔티티 그대로 조회 (Querydsl X)
//    @GetMapping("/v1")

//    DTO로 변환 후 조회 (Querydsl X)
//    @GetMapping("/v2")

//    Querydsl 사용
//    @GetMapping("/v3")

//    요구사항 추가: 이미지를 순서대로 정렬해서 주세요!
//    @GetMapping("/v4")

}

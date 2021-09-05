package com.example.bulkquery.controller;

import com.example.bulkquery.MemberInfo;
import com.example.bulkquery.dtos.DateDto;
import com.example.bulkquery.dtos.RequestMultipleFavoriteArticle;
import com.example.bulkquery.entity.Article;
import com.example.bulkquery.entity.FavoriteArticle;
import com.example.bulkquery.entity.Member;
import com.example.bulkquery.repository.ArticleRepository;
import com.example.bulkquery.repository.MemberRepository;
import com.example.bulkquery.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Api {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final MemberService memberService;

    @DeleteMapping("/members/{memberId}")
    public String deleteMemberCascade(@PathVariable Long memberId) {

        memberService.deleteMember(memberId);
        return "ok";
    }

    /**
     * opphan removal을 true로 할 경우 자식의 갯수만큼 쿼리가 더 나간다.
     * @param articleId
     * @return
     */
    @DeleteMapping("/articles/{articleId}")
    public String deleteArticleOrphanRemoval(@PathVariable Long articleId) {

        articleRepository.deleteById(articleId);
        return "ok";
    }

    @DeleteMapping("/members/{memberId}/articles/{articleId}")
    public String deleteMembersArticle(@PathVariable Long memberId, @PathVariable Long articleId) {

        memberService.deleteMembersArticle(memberId, articleId);
        return "ok";
    }

    @PostMapping("/members/{memberId}/articles/{articleId}")
    public String addFavoriteArticle(@PathVariable Long memberId, @PathVariable Long articleId) {

        memberService.addFavoriteArticle(memberId, articleId);
        return "ok";
    }

    @PostMapping("/members/{memberId}/articles")
    public String addManyFavoriteArticle(@PathVariable Long memberId,
                                         @RequestBody RequestMultipleFavoriteArticle request) {

        memberService.addMultipleFavoriteArticle(memberId, request);
        return "ok";
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<String> getMemberInfo(@PathVariable Long memberId) {
        return ResponseEntity.ok().body(memberService.getMemberInfo(memberId));
    }

    @PostMapping(value = "/date", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String getDate(@RequestPart(value = "date") DateDto dateDto,
                          @RequestPart(value = "files", required = false) MultipartFile file) {

        return "Date 확인";
    }
}

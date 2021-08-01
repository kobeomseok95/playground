package com.example.bulkquery.service;

import com.example.bulkquery.MemberInfo;
import com.example.bulkquery.dtos.RequestMultipleFavoriteArticle;
import com.example.bulkquery.entity.Article;
import com.example.bulkquery.entity.FavoriteArticle;
import com.example.bulkquery.entity.Member;
import com.example.bulkquery.repository.ArticleRepository;
import com.example.bulkquery.repository.FavoriteArticleRepository;
import com.example.bulkquery.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final FavoriteArticleRepository favoriteRepository;
    private final ArticleRepository articleRepository;

    public void deleteMember(Long memberId) {
        favoriteRepository.deleteByMemberId(memberId);
        memberRepository.deleteByMemberId(memberId);
    }

    public void deleteMembersArticle(Long memberId, Long articleId) {
        Member member = memberRepository.findByIdFetch(memberId).orElseThrow();
        member.getFavoriteArticleList()
                .removeIf(favoriteArticle -> favoriteArticle.getArticle().getId().equals(articleId));
    }

    public void addFavoriteArticle(Long memberId, Long articleId) {
        Article favoriteArticle = articleRepository.findById(articleId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.getFavoriteArticleList().add(FavoriteArticle.builder()
                .member(member).article(favoriteArticle)
                .build());
    }

    public String getMemberInfo(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member.getUsername();
    }

    public void addMultipleFavoriteArticle(Long memberId, RequestMultipleFavoriteArticle request) {

        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Article> favoriteArticleList = articleRepository
                .findAllById(request.getArticleIdList());
        member.addFavoriteArticleList(favoriteArticleList);
    }
}

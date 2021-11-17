package com.demo.querydslexample.configs;

import com.demo.querydslexample.entity.Address;
import com.demo.querydslexample.entity.Article;
import com.demo.querydslexample.entity.Member;
import com.demo.querydslexample.repository.AddressRepository;
import com.demo.querydslexample.repository.ArticleRepository;
import com.demo.querydslexample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        Member member1 = Member.of("member1");
        Member member2 = Member.of("member2");
        memberRepository.saveAll(List.of(member1, member2));

        // Member1은 주소가 2개, 게시글이 1개
        Address address1 = Address.of(member1, "멤버1-주소1");
        Address address2 = Address.of(member1, "멤버1-주소2");
        addressRepository.saveAll(List.of(address1, address2));

        Article article1 = Article.of(member1, "멤버1-게시글1");
        articleRepository.save(article1);

        // Member2는 주소가 1개, 게시글이 3개
        Address address3 = Address.of(member2, "멤버2-주소1");
        addressRepository.save(address3);

        Article article2 = Article.of(member2, "멤버2-게시글1");
        Article article3 = Article.of(member2, "멤버2-게시글2");
        Article article4 = Article.of(member2, "멤버2-게시글3");
        articleRepository.saveAll(List.of(article2, article3, article4));

        log.info("======== Complete Insert Dummy Data..");
    }
}

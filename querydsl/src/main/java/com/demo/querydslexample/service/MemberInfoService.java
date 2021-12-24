package com.demo.querydslexample.service;

import com.demo.querydslexample.controller.dto.MemberInfo;
import com.demo.querydslexample.entity.Member;
import com.demo.querydslexample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoService {

    private final MemberRepository memberRepository;

    public List<MemberInfo> getMembersInfo() {
        return memberRepository.getMembersInfo();
    }

    public List<Member> getMember() {
        List<Member> all = memberRepository.findAll();
        for (Member member : all) {
            log.info("member = {}", member.getUsername());
        }
        return all;
    }
}

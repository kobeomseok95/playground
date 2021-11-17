package com.demo.querydslexample.service;

import com.demo.querydslexample.controller.dto.MemberInfo;
import com.demo.querydslexample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoService {

    private final MemberRepository memberRepository;

    public List<MemberInfo> getMembersInfo() {
        return memberRepository.getMembersInfo();
    }
}

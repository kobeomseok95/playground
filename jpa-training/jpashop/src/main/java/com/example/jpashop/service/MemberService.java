package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;

import java.util.List;

public interface MemberService {

    List<MemberDto> getMembers();

    MemberDto getMember(Long id);

    MemberDto join(MemberDto request) throws Exception;

    void validDuplicateMemberName(String name) throws Exception;
}

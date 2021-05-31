package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;

import java.util.List;

public interface MemberService {

    List<Member> getMembers();

    Member getMember();

    MemberDto.JoinResponse join(MemberDto.JoinRequest request) throws Exception;

    void validDuplicateMemberName(String name) throws Exception;
}

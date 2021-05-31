package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.util.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public List<Member> getMembers() {
        return null;
    }

    @Override
    public Member getMember() {
        return null;
    }

    @Override
    public MemberDto.JoinResponse join(MemberDto.JoinRequest request) throws Exception {

        validDuplicateMemberName(request.getName());
        Member member = memberMapper.joinRequestToMember(request);
        memberRepository.save(member);
        return memberMapper.memberToJoinResponse(member);
    }

    @Override
    public void validDuplicateMemberName(String name) throws Exception {
        memberRepository.findByName(name).ifPresent(m -> {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
    }
}

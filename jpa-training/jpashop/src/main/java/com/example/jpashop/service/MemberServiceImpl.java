package com.example.jpashop.service;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.util.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::memberToMemberDto)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto getMember(Long id) {
        return memberMapper.memberToMemberDto(memberRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("일치하는 회원이 없습니다.");
        }));
    }

    @Override
    public MemberDto join(MemberDto request) throws Exception {

        validDuplicateMemberName(request.getName());
        Member member = memberMapper.memberDtoToMember(request);
        memberRepository.save(member);
        return memberMapper.memberToMemberDto(member);
    }

    @Override
    public void validDuplicateMemberName(String name) throws Exception {
        memberRepository.findByName(name).ifPresent(m -> {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
    }
}

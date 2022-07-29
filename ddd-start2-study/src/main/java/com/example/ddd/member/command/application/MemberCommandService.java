package com.example.ddd.member.command.application;

import com.example.ddd.member.command.application.request.UpdateMemberInfoRequestDto;
import com.example.ddd.member.command.domain.Member;
import com.example.ddd.member.command.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public void changeMemberInfo(UpdateMemberInfoRequestDto updateMemberInfoRequestDto) {
        Member member = memberRepository.findById(updateMemberInfoRequestDto.getMemberId())
                .orElseThrow();
        member.changeInfo(updateMemberInfoRequestDto.getMemberName(), updateMemberInfoRequestDto.getPhone());
    }
}

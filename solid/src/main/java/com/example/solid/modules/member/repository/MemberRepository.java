package com.example.solid.modules.member.repository;

import com.example.solid.modules.member.application.port.out.MemberFindQuery;
import com.example.solid.modules.member.application.port.out.UpdateMemberState;
import com.example.solid.modules.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRepository
        implements MemberFindQuery,
        UpdateMemberState {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public boolean existsByPhone(String phone) {
        return memberJpaRepository.existsByPhone(phone);
    }

    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(member);
    }
}

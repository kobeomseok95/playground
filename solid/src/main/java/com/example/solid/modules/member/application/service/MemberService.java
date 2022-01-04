package com.example.solid.modules.member.application.service;

import com.example.solid.modules.member.application.port.in.MemberJoinRequest;
import com.example.solid.modules.member.application.port.in.MemberUseCase;
import com.example.solid.modules.member.application.port.out.MemberFindQuery;
import com.example.solid.modules.member.application.port.out.UpdateMemberState;
import com.example.solid.modules.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService implements MemberUseCase {

    private final MemberFindQuery memberFindQuery;
    private final UpdateMemberState updateMemberState;

    @Override
    public boolean join(MemberJoinRequest memberJoinRequest) {
        if (!memberFindQuery.existsByPhone(
                memberJoinRequest.getPhone())) {
            updateMemberState.save(Member
                    .build(memberJoinRequest.getPhone()));
            return true;
        }
        throw new IllegalArgumentException("이미 가입한 회원입니다.");
    }
}

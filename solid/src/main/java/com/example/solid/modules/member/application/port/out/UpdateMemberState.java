package com.example.solid.modules.member.application.port.out;

import com.example.solid.modules.member.domain.Member;

public interface UpdateMemberState {

    Member save(Member member);
}

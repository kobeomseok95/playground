package com.example.solid.common;

import com.example.solid.modules.member.domain.Member;

public class MemberFactory {

    public static Member member(String phone) {
        return Member.builder()
                .phone(phone)
                .build();
    }
}

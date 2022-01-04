package com.example.solid.unit.modules.member.domain;

import com.example.solid.modules.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberTest {

    @Test
    @DisplayName("회원 생성")
    void member_build() throws Exception {

        // given
        final String phone = "010-1234-1234";

        // when
        Member member = Member.build(phone);

        // then
        assertEquals(member.getPhone(), phone);
    }
}

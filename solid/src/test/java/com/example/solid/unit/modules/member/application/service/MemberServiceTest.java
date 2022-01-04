package com.example.solid.unit.modules.member.application.service;

import com.example.solid.modules.member.application.port.in.MemberJoinRequest;
import com.example.solid.modules.member.application.port.out.MemberFindQuery;
import com.example.solid.modules.member.application.port.out.UpdateMemberState;
import com.example.solid.modules.member.application.service.MemberService;
import com.example.solid.modules.member.domain.Member;
import com.example.solid.unit.modules.member.application.port.in.MockMemberJoinRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberFindQuery memberFindQuery;
    @Mock
    UpdateMemberState updateMemberState;
    @InjectMocks MemberService memberService;

    @Test
    @DisplayName("회원 가입 / 성공")
    void join() throws Exception {

        // given
        MemberJoinRequest request = MockMemberJoinRequest.createRequest();
        when(memberFindQuery.existsByPhone(request.getPhone())).thenReturn(false);

        // when
        boolean result = memberService.join(request);

        // then
        assertAll(
                () -> assertTrue(result),
                () -> verify(memberFindQuery).existsByPhone(request.getPhone()),
                () -> verify(updateMemberState).save(any(Member.class))
        );
    }

    @Test
    @DisplayName("회원 가입 / 실패, 휴대전화가 존재하는 경우")
    void join_fail_exist_member_by_phone() throws Exception {

        // given
        MemberJoinRequest request = MockMemberJoinRequest.createRequest();
        when(memberFindQuery.existsByPhone(request.getPhone())).thenReturn(true);

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> memberService.join(request));
    }
}

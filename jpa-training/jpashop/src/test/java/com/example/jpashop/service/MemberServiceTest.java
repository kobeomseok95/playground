package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.dummy.MemberDummy;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.util.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;
    @Mock
    MemberMapper memberMapper;

    @InjectMocks
    MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입")
    void join() {

        // given
        MemberDto.JoinRequest request = mock(MemberDto.JoinRequest.class);
        Member member = mock(Member.class);
        MemberDto.JoinResponse response = mock(MemberDto.JoinResponse.class);

        when(memberMapper.joinRequestToMember(request)).thenReturn(member);
        when(memberRepository.save(member)).thenReturn(member);
        when(memberMapper.memberToJoinResponse(member)).thenReturn(response);

        // when
        memberService.join(request);

        // then
        verify(memberMapper).joinRequestToMember(request);
        verify(memberRepository).save(member);
        verify(memberMapper).memberToJoinResponse(member);
    }
}

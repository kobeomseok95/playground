package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.util.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;
    @Mock
    MemberMapper memberMapper;

    @Spy @InjectMocks
    MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입")
    void join() throws Exception {

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
        verify(memberService).validDuplicateMemberName(any());
        verify(memberMapper).joinRequestToMember(request);
        verify(memberRepository).save(member);
        verify(memberMapper).memberToJoinResponse(member);
    }

    @Test
    @DisplayName("회원명 중복시 예외")
    void validDuplicateMemberName() throws Exception{

        // given
        when(memberRepository.findByName(anyString()).isPresent())
                .thenThrow(IllegalStateException.class);

        // when
        assertThrows(IllegalStateException.class, () -> {
            memberService.validDuplicateMemberName(anyString());
        });

        // then
        verify(memberRepository).findByName(anyString());
    }
}

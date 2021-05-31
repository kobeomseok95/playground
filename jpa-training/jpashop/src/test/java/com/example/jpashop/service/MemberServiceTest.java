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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;
    @Mock
    MemberMapper memberMapper;

    @Spy
    @InjectMocks
    MemberServiceImpl memberService;

    @Test
    @DisplayName("회원가입")
    void join() throws Exception {

        // given
        MemberDto request = mock(MemberDto.class);
        Member member = mock(Member.class);
        MemberDto response = mock(MemberDto.class);

        when(memberMapper.memberDtoToMember(request)).thenReturn(member);
        when(memberRepository.save(member)).thenReturn(member);
        when(memberMapper.memberToMemberDto(member)).thenReturn(response);

        // when
        memberService.join(request);

        // then
        verify(memberService).validDuplicateMemberName(any());
        verify(memberMapper).memberDtoToMember(request);
        verify(memberRepository).save(member);
        verify(memberMapper).memberToMemberDto(member);
    }

    @Test
    @DisplayName("회원명 중복시 예외")
    void validDuplicateMemberName() throws Exception {

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

    @Test
    @DisplayName("모든 회원 조회 (일단 멤버만)")
    void getAllMembers() throws Exception {

        // given
        List<MemberDto> memberDtos = mock(List.class);

        when(memberRepository.findAll().stream()
                .map(memberMapper::memberToMemberDto)
                .collect(Collectors.toList()))
        .thenReturn(memberDtos);

        // when
        memberService.getMembers();

        // then
        verify(memberRepository).findAll();
    }

    @Test
    @DisplayName("회원 한명 조회")
    void getMember() throws Exception {

        // given
        Member member = mock(Member.class);
        MemberDto memberDto = mock(MemberDto.class);
        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        when(memberMapper.memberToMemberDto(member)).thenReturn(memberDto);

        // when
        memberService.getMember(100L);

        // then
        verify(memberRepository).findById(anyLong());
        verify(memberMapper).memberToMemberDto(member);
    }
}

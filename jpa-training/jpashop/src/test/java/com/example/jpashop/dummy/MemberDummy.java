package com.example.jpashop.dummy;

import com.example.jpashop.dto.MemberDto;

public class MemberDummy {

    public static MemberDto.JoinRequest createJoinMember() {
        return MemberDto.JoinRequest.builder()
                .name("테스트회원")
                .city("서울시")
                .street("광진구 중곡동")
                .zipcode("04941")
                .build();
    }
}

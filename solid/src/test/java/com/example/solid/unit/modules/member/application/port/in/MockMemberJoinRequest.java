package com.example.solid.unit.modules.member.application.port.in;

import com.example.solid.modules.member.application.port.in.MemberJoinRequest;

public class MockMemberJoinRequest {

    public static MemberJoinRequest createRequest() {
        return MemberJoinRequest.builder()
                .phone("010-1234-1234")
                .build();
    }
}

package com.example.ddd.member.command.domain;

import lombok.Getter;

@Getter
public class MemberInfoChangedEvent {

    private Long memberId;
    private String memberName;
    private String phone;

    public MemberInfoChangedEvent(Long memberId, String memberName, String phone) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.phone = phone;
    }
}

package com.example.ddd.member.command.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateMemberInfoRequestDto {

    private Long memberId;
    private String memberName;
    private String phone;
}

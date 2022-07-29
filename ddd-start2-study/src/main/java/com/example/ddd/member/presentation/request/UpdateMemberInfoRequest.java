package com.example.ddd.member.presentation.request;

import com.example.ddd.member.command.application.request.UpdateMemberInfoRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberInfoRequest {

    private String memberName;
    private String phone;

    public UpdateMemberInfoRequestDto toRequestDto(Long memberId) {
        return UpdateMemberInfoRequestDto.builder()
                .memberId(memberId)
                .memberName(memberName)
                .phone(phone)
                .build();
    }
}

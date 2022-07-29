package com.example.ddd.member.presentation;

import com.example.ddd.member.command.application.MemberCommandService;
import com.example.ddd.member.presentation.request.UpdateMemberInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PutMapping("/{memberId}")
    public void changeMemberInfo(@PathVariable Long memberId,
                                 @RequestBody UpdateMemberInfoRequest updateMemberInfoRequest) {
        memberCommandService.changeMemberInfo(updateMemberInfoRequest.toRequestDto(memberId));
    }
}

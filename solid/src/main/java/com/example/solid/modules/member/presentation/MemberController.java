package com.example.solid.modules.member.presentation;

import com.example.solid.modules.member.application.port.in.MemberJoinRequest;
import com.example.solid.modules.member.application.port.in.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberUseCase memberUseCase;

    @PostMapping("")
    public ResponseEntity<Void> join(@RequestBody MemberJoinRequest memberJoinRequest) {
        memberUseCase.join(memberJoinRequest);
        return ResponseEntity.ok().build();
    }
}

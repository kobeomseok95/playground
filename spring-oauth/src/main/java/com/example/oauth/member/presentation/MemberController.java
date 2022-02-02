package com.example.oauth.member.presentation;

import com.example.oauth.member.domain.Member;
import com.example.oauth.member.util.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    @GetMapping("/me")
    public ResponseEntity<Member> getMemberInfo(@AuthUser Member member) {
        return ResponseEntity.ok(member);
    }
}

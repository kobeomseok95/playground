package com.example.jpashop.controller;

import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<List<MemberDto>> getMembers() {

        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto> getMembers(@PathVariable("memberId") Long id) {

        return ResponseEntity.ok(memberService.getMember(id));
    }

    @PostMapping("/")
    public ResponseEntity<MemberDto> join(@RequestBody MemberDto request) throws Exception {

        return ResponseEntity.ok(memberService.join(request));
    }
}

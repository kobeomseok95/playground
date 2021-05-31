package com.example.jpashop.controller;

import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

//    @GetMapping("/")
//    public ResponseEntity<> getMembers() {
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMembers());
//    }
//    @GetMapping("/{memberId}")

    @PostMapping("/")
    public ResponseEntity<MemberDto> join(@RequestBody MemberDto request) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(memberService.join(request));
    }
}

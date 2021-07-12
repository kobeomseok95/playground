package com.example.exceptionguide.controller;

import com.example.exceptionguide.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final MemberService memberService;

    @GetMapping("/api/notfound/{memberId}")
    public void notFound(@PathVariable("memberId") Long memberId) {

        memberService.notFound(memberId);
    }


    @GetMapping("/api/notlogin/{memberId}")
    public void notLogin(@PathVariable("memberId") Long memberId) {

        memberService.notLogin(memberId);
    }
}

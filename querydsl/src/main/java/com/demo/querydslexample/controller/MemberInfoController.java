package com.demo.querydslexample.controller;

import com.demo.querydslexample.controller.dto.MemberInfo;
import com.demo.querydslexample.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberInfoController {

    private final MemberInfoService service;

    @GetMapping("/members/info")
    public ResponseEntity<List<MemberInfo>> membersInfo() {
        return ResponseEntity.ok(service.getMembersInfo());
    }
}

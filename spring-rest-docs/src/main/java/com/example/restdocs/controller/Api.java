package com.example.restdocs.controller;

import com.example.restdocs.dto.GetResponse;
import com.example.restdocs.dto.PostRequest;
import com.example.restdocs.dto.PostResponse;
import com.example.restdocs.services.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class Api {

    private final RestService restService;

    @GetMapping("/{id}")
    public ResponseEntity<List<GetResponse>> get(@PathVariable Long id) {
        return ResponseEntity.ok(restService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<PostResponse> post(@RequestBody PostRequest request) {
        return ResponseEntity.ok(restService.post(request));
    }
}

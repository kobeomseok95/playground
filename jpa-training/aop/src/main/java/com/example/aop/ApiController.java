package com.example.aop;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Timer
    @GetMapping("/{id}")
    public String getId(@PathVariable Long id) {
        return  "[GET] " + id.toString();
    }

    @Timer
    @PostMapping("/{id}")
    public String postId(@PathVariable Long id) {
        return "[POST] " + id.toString();
    }

    @Timer
    @PatchMapping("/{id}")
    public String patchId(@PathVariable Long id) {
        return "[PATCH] " + id.toString();
    }

    @Timer
    @DeleteMapping("/{id}")
    public String deleteId(@PathVariable Long id) {
        return "[DELETE] " + id.toString();
    }
}

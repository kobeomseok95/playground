package com.mapping.relation.threadlocal.controller;


import com.mapping.relation.threadlocal.service.CompositeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ThreadLocalRestController {

    private final CompositeService compositeService;

    @GetMapping("/api/threadlocal")
    public void ex(@RequestParam("name") String name) {
        compositeService.logic(name);
    }
}

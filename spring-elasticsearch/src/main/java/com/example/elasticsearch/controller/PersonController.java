package com.example.elasticsearch.controller;

import com.example.elasticsearch.domain.Person;
import com.example.elasticsearch.service.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final ElasticsearchService esService;

    @PostMapping("")
    public String save(@RequestBody Person person) {
        return esService.index(person);
    }
}

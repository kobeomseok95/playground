package com.example.elasticache.controller;

import com.example.elasticache.domain.Person;
import com.example.elasticache.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Person post(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person get(@PathVariable("id") String id) {
        return personService.find(id);
    }
}

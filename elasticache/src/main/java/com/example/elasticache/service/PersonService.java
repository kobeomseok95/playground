package com.example.elasticache.service;

import com.example.elasticache.controller.PersonDto;
import com.example.elasticache.domain.Person;
import com.example.elasticache.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(PersonDto personDto) {
        return personRepository.save(Person.of(personDto));
    }

    public Person find(String id) {
        return personRepository.findById(id).orElseThrow();
    }
}

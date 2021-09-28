package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Person;

public interface ElasticsearchService {

    String index(Person person);

    Person find(String id);
}

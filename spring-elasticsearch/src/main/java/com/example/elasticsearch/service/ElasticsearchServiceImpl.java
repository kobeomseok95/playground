package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.DocumentOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ElasticsearchServiceImpl implements ElasticsearchService{

    private final ElasticsearchOperations operations;

    @Override
    public String index(Person person) {
        IndexCoordinates coordinates = IndexCoordinates.of("person");
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId())
                .withObject(person)
                .build();

        return operations.index(indexQuery, coordinates);
    }

    @Override
    public Person find(String id) {
        return operations.get(id, Person.class);
    }
}

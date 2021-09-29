package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Lecture;
import com.example.elasticsearch.domain.Person;
import com.example.elasticsearch.dto.SearchQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

public interface ElasticsearchService {

    String index(Person person);

    Person find(String id);

    List<IndexedObjectInformation> bulk(List<Lecture> lectureList);

    SearchHits<Lecture> search(Pageable pageable, SearchQuery searchQuery);
}

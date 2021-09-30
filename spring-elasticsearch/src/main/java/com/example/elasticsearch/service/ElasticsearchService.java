package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Lecture;
import com.example.elasticsearch.domain.Person;
import com.example.elasticsearch.dto.SearchQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;

import java.io.IOException;
import java.util.List;

public interface ElasticsearchService {

    String index(Person person);

    Lecture findByLectureId(Long lectureId);

    Lecture findById(String id);

    List<IndexedObjectInformation> bulkInsert(List<Lecture> lectureList);

    SearchHits<Lecture> search(Pageable pageable, SearchQuery searchQuery);

    void bulkUpdate(List<Lecture> lectureList) throws JsonProcessingException;

    CreateIndexResponse createIndex() throws IOException;
}

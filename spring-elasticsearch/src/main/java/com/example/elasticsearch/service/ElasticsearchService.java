package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.LectureDocument;
import com.example.elasticsearch.dto.SearchQuery;
import com.example.elasticsearch.entity.LectureEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.io.IOException;
import java.util.List;

public interface ElasticsearchService {

    LectureDocument findByLectureId(Long lectureId);

    LectureDocument findById(String id);

    List<IndexedObjectInformation> bulkInsert(List<LectureDocument> lectureDocumentList);

    SearchHits<LectureDocument> search(Pageable pageable, SearchQuery searchQuery);

    void bulkUpdate(List<LectureDocument> lectureDocumentList) throws JsonProcessingException;

    CreateIndexResponse createIndex() throws IOException;

    void modifyDb(Long id);
}

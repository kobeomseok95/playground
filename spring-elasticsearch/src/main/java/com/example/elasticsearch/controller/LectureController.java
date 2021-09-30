package com.example.elasticsearch.controller;

import com.example.elasticsearch.domain.LectureDocument;
import com.example.elasticsearch.dto.SearchQuery;
import com.example.elasticsearch.service.ElasticsearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {

    private final ElasticsearchService elasticsearchService;

    @PostMapping("/lecture")
    public CreateIndexResponse createIndex() throws IOException {
        return elasticsearchService.createIndex();
    }

    @PostMapping("/bulk")
    public List<IndexedObjectInformation> bulkInsert(@RequestBody List<LectureDocument> lectureDocumentList) {
        return elasticsearchService.bulkInsert(lectureDocumentList);
    }

    @PutMapping("/bulk")
    public void bulkUpdate(@RequestBody List<LectureDocument> lectureDocumentList) throws JsonProcessingException {
        elasticsearchService.bulkUpdate(lectureDocumentList);
    }

    @GetMapping("/search")
    public SearchHits<LectureDocument> search(Pageable pageable, SearchQuery searchQuery) {
        return elasticsearchService.search(pageable, searchQuery);
    }

    @GetMapping("/{lectureId}")
    public LectureDocument find(@PathVariable Long lectureId) {
        return elasticsearchService.findByLectureId(lectureId);
    }
}

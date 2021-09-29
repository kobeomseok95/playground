package com.example.elasticsearch.controller;

import com.example.elasticsearch.domain.Lecture;
import com.example.elasticsearch.dto.SearchQuery;
import com.example.elasticsearch.service.ElasticsearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {

    private final ElasticsearchService elasticsearchService;

    @PostMapping("/bulk")
    public List<IndexedObjectInformation> bulk(@RequestBody List<Lecture> lectureList) {
        return elasticsearchService.bulk(lectureList);
    }

    @GetMapping("/search")
    public SearchHits<Lecture> search(Pageable pageable, SearchQuery searchQuery) {
        return elasticsearchService.search(pageable, searchQuery);
    }
}

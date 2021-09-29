package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Lecture;
import com.example.elasticsearch.domain.Person;
import com.example.elasticsearch.dto.SearchQuery;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    @Override
    public List<IndexedObjectInformation> bulk(List<Lecture> lectureList) {
        IndexCoordinates coordinates = IndexCoordinates.of("lecture");
        List<IndexQuery> bulkIndexQueries = lectureList.stream()
                .map(lecture -> new IndexQueryBuilder()
                        .withId(lecture.getId())
                        .withObject(lecture)
                        .build())
                .collect(toList());

        return operations.bulkIndex(bulkIndexQueries, coordinates);
    }

    @Override
    public SearchHits<Lecture> search(Pageable pageable, SearchQuery searchQuery) {

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(DynamicSearchQueryBuilder.makeQuery(searchQuery))
                .withSort(SortBuilders.scoreSort())
                .withPageable(pageable)
                .build();

        SearchHits<Lecture> search = operations.search(query, Lecture.class);
        List<SearchHit<Lecture>> searchHits = search.getSearchHits();
        return search;
    }
}























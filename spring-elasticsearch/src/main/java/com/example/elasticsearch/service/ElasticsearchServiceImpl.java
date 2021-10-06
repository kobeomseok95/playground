package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.LectureDocument;
import com.example.elasticsearch.dto.SearchQuery;
import com.example.elasticsearch.entity.LectureEntity;
import com.example.elasticsearch.entity.LectureEntityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;
import static org.elasticsearch.common.xcontent.XContentType.JSON;

@Service
@RequiredArgsConstructor
@Transactional
public class ElasticsearchServiceImpl implements ElasticsearchService{

    private final ElasticsearchOperations operations;
    private final RestHighLevelClient client;
    private final ObjectMapper objectMapper;
    private final LectureEntityRepository lectureEntityRepository;
    private final ResourceLoader resourceLoader;

    @Override
    public List<IndexedObjectInformation> bulkInsert(List<LectureDocument> lectureDocumentList) {

        IndexCoordinates coordinates = IndexCoordinates.of("lecture");
        List<IndexQuery> bulkIndexQueries = lectureDocumentList.stream()
                .map(lectureDocument -> new IndexQueryBuilder()
                        .withId(lectureDocument.getId())
                        .withObject(lectureDocument)
                        .build())
                .collect(toList());

        return operations.bulkIndex(bulkIndexQueries, coordinates);
    }

    @Override
    public void bulkUpdate(List<LectureDocument> lectureDocumentList) throws JsonProcessingException {
        IndexCoordinates index = IndexCoordinates.of("lecture");
        List<Long> lectureIdList = lectureDocumentList.stream().map(LectureDocument::getLectureId).collect(toList());

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("lectureId", lectureIdList))).build();
        List<String> esIdList = operations.search(searchQuery, LectureDocument.class).stream().map(lectureSearchHit -> lectureSearchHit.getContent().getId()).collect(toList());

        List<UpdateQuery> updateQueryList = new ArrayList<>();
        for (int i = 0; i < esIdList.size(); i++) {
            updateQueryList.add(
                    UpdateQuery.builder(esIdList.get(i)).withDocument(Document.create().fromJson(objectMapper.writeValueAsString(lectureDocumentList.get(i)))).build()
            );
        }
        operations.bulkUpdate(updateQueryList, index);
    }

    @Override
    public CreateIndexResponse createIndex() throws IOException {
        Resource settingsResource = resourceLoader.getResource("classpath:elasticsearch/lecture-settings.json");
        String settings = new String(FileCopyUtils.copyToByteArray(settingsResource.getInputStream()), UTF_8);

        Resource mappingsResource = resourceLoader.getResource("classpath:elasticsearch/lecture-mappings.json");
        String mappings = new String(FileCopyUtils.copyToByteArray(mappingsResource.getInputStream()), UTF_8);

        CreateIndexRequest request = new CreateIndexRequest("lecture");
        request.settings(settings, JSON);
        request.mapping(mappings, JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        client.close();
        return createIndexResponse;
    }

    @Override
    public void modifyDb(Long id) {
        LectureEntity find = lectureEntityRepository.findById(id).orElseThrow();
        find.setTitle("수정수정");
    }

    @Override
    public LectureDocument findByLectureId(Long lectureId) {
        NativeSearchQuery findByLectureIdQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("lectureId", lectureId)).build();
        SearchHits<LectureDocument> search = operations.search(findByLectureIdQuery, LectureDocument.class);
        return search.getSearchHit(0).getContent();
    }

    @Override
    public LectureDocument findById(String id) {
        return operations.get(id, LectureDocument.class);
    }

    @Override
    public SearchHits<LectureDocument> search(Pageable pageable, SearchQuery searchQuery) {

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(DynamicSearchQueryBuilder.makeQuery(searchQuery))
                .withSort(SortBuilders.scoreSort())
                .withPageable(pageable)
                .build();

        SearchHits<LectureDocument> search = operations.search(query, LectureDocument.class);
        List<SearchHit<LectureDocument>> searchHits = search.getSearchHits();
        return search;
    }
}























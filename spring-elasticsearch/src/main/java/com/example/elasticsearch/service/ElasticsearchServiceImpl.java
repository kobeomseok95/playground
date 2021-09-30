package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Lecture;
import com.example.elasticsearch.domain.Person;
import com.example.elasticsearch.dto.SearchQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.elasticsearch.common.xcontent.XContentType.JSON;

@Service
@RequiredArgsConstructor
@Transactional
public class ElasticsearchServiceImpl implements ElasticsearchService{

    private final ElasticsearchOperations operations;
    private final RestHighLevelClient client;
    private final ObjectMapper objectMapper;

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
    public List<IndexedObjectInformation> bulkInsert(List<Lecture> lectureList) {

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
    public void bulkUpdate(List<Lecture> lectureList) throws JsonProcessingException {
        IndexCoordinates index = IndexCoordinates.of("lecture");
        List<Long> lectureIdList = lectureList.stream().map(Lecture::getLectureId).collect(toList());

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("lectureId", lectureIdList))).build();
        List<String> esIdList = operations.search(searchQuery, Lecture.class).stream().map(lectureSearchHit -> lectureSearchHit.getContent().getId()).collect(toList());

        List<UpdateQuery> updateQueryList = new ArrayList<>();
        for (int i = 0; i < esIdList.size(); i++) {
            updateQueryList.add(
                    UpdateQuery.builder(esIdList.get(i)).withDocument(Document.create().fromJson(objectMapper.writeValueAsString(lectureList.get(i)))).build()
            );
        }
        operations.bulkUpdate(updateQueryList, index);
    }

    @Override
    public CreateIndexResponse createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("lecture");
        request.settings("{\n" +
                "  \"analysis\": {\n" +
                "    \"analyzer\": {\n" +
                "      \"my_analyzer\": {\n" +
                "        \"type\": \"custom\",\n" +
                "        \"tokenizer\": \"nori_tokenizer_mixed_dict\",\n" +
                "        \"filter\": \"my_posfilter\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"tokenizer\": {\n" +
                "      \"nori_tokenizer_mixed_dict\": {\n" +
                "        \"type\": \"nori_tokenizer\",\n" +
                "        \"decompound_mode\": \"mixed\",\n" +
                "        \"discard_punctuation\": \"false\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"filter\": {\n" +
                "      \"my_posfilter\": {\n" +
                "        \"type\": \"nori_part_of_speech\",\n" +
                "        \"stoptags\": [\n" +
                "          \"E\",\n" +
                "          \"IC\",\n" +
                "          \"J\",\n" +
                "          \"MAG\",\n" +
                "          \"MAJ\",\n" +
                "          \"MM\",\n" +
                "          \"SP\",\n" +
                "          \"SSC\",\n" +
                "          \"SSO\",\n" +
                "          \"SC\",\n" +
                "          \"SE\",\n" +
                "          \"XPN\",\n" +
                "          \"XSA\",\n" +
                "          \"XSN\",\n" +
                "          \"XSV\",\n" +
                "          \"UNA\",\n" +
                "          \"NA\",\n" +
                "          \"VSV\"\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n", JSON);
        request.mapping("{\n" +
                "  \"properties\": {\n" +
                "    \"lectureId\" : {\"type\" : \"integer\"},\n" +
                "    \"imageUrl\" : {\"type\" : \"text\"},\n" +
                "    \"title\" : {\n" +
                "      \"type\" : \"text\",\n" +
                "      \"analyzer\": \"my_analyzer\"\n" +
                "    },\n" +
                "    \"description\" : {\n" +
                "      \"type\" : \"text\",\n" +
                "      \"analyzer\": \"my_analyzer\"\n" +
                "    },\n" +
                "    \"finishedProductText\" : {\n" +
                "      \"type\" : \"text\",\n" +
                "      \"analyzer\": \"my_analyzer\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n", JSON);
        return client.indices().create(request, RequestOptions.DEFAULT);
    }

    @Override
    public Lecture findByLectureId(Long lectureId) {
        NativeSearchQuery findByLectureIdQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("lectureId", lectureId)).build();
        SearchHits<Lecture> search = operations.search(findByLectureIdQuery, Lecture.class);
        return search.getSearchHit(0).getContent();
    }

    @Override
    public Lecture findById(String id) {
        return operations.get(id, Lecture.class);
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























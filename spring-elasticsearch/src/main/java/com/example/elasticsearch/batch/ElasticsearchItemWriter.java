package com.example.elasticsearch.batch;

import com.example.elasticsearch.domain.LectureDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class ElasticsearchItemWriter implements ItemWriter<LectureDocument> {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public void write(List<? extends LectureDocument> items) throws Exception {
        List<IndexQuery> bulkIndexQueries = items.stream()
                .map(lectureDocument -> new IndexQueryBuilder()
                        .withId(lectureDocument.getId())
                        .withObject(lectureDocument)
                        .build())
                .collect(toList());
        elasticsearchOperations.bulkIndex(bulkIndexQueries, LectureDocument.class);
    }
}

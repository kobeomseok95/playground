package com.example.elasticsearch.services;

import com.example.elasticsearch.data.Product;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ElkService {

    private static final String PRODUCT_INDEX = "productindex";

    private final ElasticsearchOperations elasticsearchOperations;
    private final RestHighLevelClient client;

    public String createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(PRODUCT_INDEX);
        request.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 2));

        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        return response.toString();
    }

    public List<IndexedObjectInformation> createProductIndexBulk(final List<Product> products) {

        List<IndexQuery> queries = products.stream()
                .map(product->
                        new IndexQueryBuilder()
                                .withId(product.getId().toString())
                                .withObject(product).build())
                .collect(Collectors.toList());;

        return elasticsearchOperations.bulkIndex(queries,IndexCoordinates.of(PRODUCT_INDEX));
    }
}

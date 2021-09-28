package com.example.elasticsearch.controller;

import com.example.elasticsearch.data.Product;
import com.example.elasticsearch.services.ElkService;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElkController {

    private final ElkService elkService;

    @PostMapping("/index-product")
    public String createProductIndex() throws IOException {
        return elkService.createIndex();
    }

    @PostMapping("/bulk-index")
    public List<IndexedObjectInformation> bulk(@RequestBody List<Product> products) {
        return elkService.createProductIndexBulk(products);
    }
}

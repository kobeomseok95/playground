package com.example.elasticsearch.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("elasticsearch")
public class ElasticsearchProperty {

    private String host;
    private String port;
}

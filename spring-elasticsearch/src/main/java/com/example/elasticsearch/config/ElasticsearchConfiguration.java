package com.example.elasticsearch.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
@RequiredArgsConstructor
public class ElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

    private final ElasticsearchProperty property;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfig = ClientConfiguration.builder()
                .connectedTo(property.getHost() + ":" + property.getPort())
                .build();

        return RestClients.create(clientConfig).rest();
    }
}

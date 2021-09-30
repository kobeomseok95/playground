package com.example.elasticsearch.batch;

import com.example.elasticsearch.domain.LectureDocument;
import com.example.elasticsearch.entity.LectureEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import javax.persistence.EntityManagerFactory;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class ElasticsearchJobConfig {

    public static final String ELASTICSEARCH_SYNC_JOB = "elasticsearchSyncJob";
    public static final String ELASTICSEARCH_SYNC_STEP = "elasticsearchSyncStep";
    public static final String LECTURE_ENTITY_ITEM_READER = "lectureItemReader";
    private static final int chunkSize = 5;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private final ElasticsearchOperations elasticsearchOperations;

    @Bean
    public Job elasticsearchSyncJob() throws Exception {
        return jobBuilderFactory.get(ELASTICSEARCH_SYNC_JOB)
                .start(elasticsearchSyncStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    @JobScope
    public Step elasticsearchSyncStep() throws Exception {
        return stepBuilderFactory.get(ELASTICSEARCH_SYNC_STEP)
                .<LectureEntity, LectureDocument>chunk(10)
                .reader(databaseReader())
                .processor(toDocumentProcessor())
                .writer(indexWriter())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<LectureEntity> databaseReader() throws Exception {
        return new JpaPagingItemReaderBuilder<LectureEntity>()
                .pageSize(5)
                .entityManagerFactory(entityManagerFactory)
                .queryString("select l from LectureEntity l")
                .name(LECTURE_ENTITY_ITEM_READER)
                .build();
    }

    @Bean
    @StepScope
    public ItemProcessor<LectureEntity, LectureDocument> toDocumentProcessor() throws Exception {
        return new ItemProcessor<LectureEntity, LectureDocument>() {
            @Override
            public LectureDocument process(LectureEntity item) throws Exception {
                return EntityToDocumentMapper.toDocument(item);
            }
        };
    }

    @Bean
    @StepScope
    public ElasticsearchItemWriter indexWriter() {
        log.info("===========================실행");
        return new ElasticsearchItemWriter(elasticsearchOperations);
    }
}

















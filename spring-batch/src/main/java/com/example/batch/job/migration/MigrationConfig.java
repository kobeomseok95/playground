package com.example.batch.job.migration;

import com.example.batch.job.migration.core.domain.Accounts;
import com.example.batch.job.migration.core.domain.AccountsRepository;
import com.example.batch.job.migration.core.domain.OrderRepository;
import com.example.batch.job.migration.core.domain.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MigrationConfig {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job migrationJob(Step migrationStep) {
        return jobBuilderFactory.get("migrationJob")
                .incrementer(new RunIdIncrementer())
                .start(migrationStep)
                .build();
    }

    @JobScope
    @Bean
    public Step migrationStep(
            ItemReader<Orders> ordersItemReader,
            ItemProcessor<Orders, Accounts> ordersToAccountsItemProcessor,
            ItemWriter<Accounts> accountsItemWriter
    ) {
        return stepBuilderFactory.get("migrationStep")
                .<Orders, Accounts>chunk(5)
                .reader(ordersItemReader)
                .processor(ordersToAccountsItemProcessor)
                .writer(accountsItemWriter)
                .build();
    }

    @StepScope
    @Bean
    public RepositoryItemReader<Orders> ordersItemReader() {
        return new RepositoryItemReaderBuilder<Orders>()
                .name("ordersItemReader")
                .repository(orderRepository)
                .methodName("findAll")
                .pageSize(5)
                .arguments(List.of())
                .sorts(Collections.singletonMap("id", Sort.Direction.ASC))
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Orders, Accounts> ordersToAccountsItemProcessor() {
        return Accounts::new;
    }

    @StepScope
    @Bean
    public RepositoryItemWriter<Accounts> accountItemWriter() {
        return new RepositoryItemWriterBuilder<Accounts>()
                .repository(accountsRepository)
                .methodName("save")
                .build();
    }

    @StepScope
    @Bean
    public ItemWriter<Accounts> commonOrdersItemReader() {
        return new ItemWriter<Accounts>() {
            @Override
            public void write(List<? extends Accounts> items) throws Exception {
                items.forEach(item -> accountsRepository.save(item));
            }
        };
    }
}

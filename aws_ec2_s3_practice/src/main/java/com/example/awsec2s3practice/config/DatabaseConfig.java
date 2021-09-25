package com.example.awsec2s3practice.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {

    private final DatabaseProperty databaseProperty;

    public DataSource createDataSource(String url) {
        log.info("================ JDBC URL = " + url);
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setDriverClassName(databaseProperty.getDriverClassName());
        hikariDataSource.setUsername(databaseProperty.getUsername());
        hikariDataSource.setPassword(databaseProperty.getPassword());
        return hikariDataSource;
    }

    @Bean
    public DataSource routingDataSource() {
        ReplicationRoutingDataSource replicationRoutingDataSource = new ReplicationRoutingDataSource();
        Map<Object, Object> dataSourceMap = new LinkedHashMap<>();
        DataSource masterDataSource = createDataSource(databaseProperty.getUrl());
        dataSourceMap.put("master", masterDataSource);
        databaseProperty.getSlaveList().forEach(slave -> {
            dataSourceMap.put(slave.getName(), createDataSource(slave.getUrl()));
        });

        replicationRoutingDataSource.setTargetDataSources(dataSourceMap);
        replicationRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        return replicationRoutingDataSource;
    }

    @Bean
    public DataSource dataSource() {
        return new LazyConnectionDataSourceProxy(routingDataSource());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.example.awsec2s3practice");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }
}

package com.querydsl.lesson.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;

import javax.persistence.EntityManager;

//@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager entityManager;

//    @Bean
//    public JPAQueryFactory jpaQueryFactory() {
//        return new JPAQueryFactory(em);
//    }
}

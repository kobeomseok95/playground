package com.mongo.data.models

import org.springframework.data.domain.Page
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface ProductRepository: MongoRepository<Product, String>, QuerydslPredicateExecutor<Product> {
    fun findQuery(query: ProductQuery): Page<Product>
}

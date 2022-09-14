package com.mongo.data.models

import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String> {
}
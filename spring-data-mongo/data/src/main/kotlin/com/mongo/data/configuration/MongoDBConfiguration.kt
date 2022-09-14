package com.mongo.data.configuration

import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.mapping.MongoMappingContext

@Configuration
@EnableMongoAuditing
class MongoDBConfiguration {

    @Bean
    @ConfigurationProperties("spring.data.mongodb")
    fun properties(): MongoProperties = MongoProperties()

    @Bean
    fun mongoClientDatabaseFactory(properties: MongoProperties) =
        SimpleMongoClientDatabaseFactory(properties.uri)

    @Bean
    fun transactionManager(databaseFactory: MongoDatabaseFactory) =
        MongoTransactionManager(databaseFactory)

    @Bean
    fun mappingMongoConverter(mongoMappingContext: MongoMappingContext): MappingMongoConverter {
        val resolver = DefaultDbRefResolver(mongoClientDatabaseFactory(properties()))
        val converter = MappingMongoConverter(resolver, mongoMappingContext)
        converter.setTypeMapper(DefaultMongoTypeMapper(null))
        return converter
    }
}

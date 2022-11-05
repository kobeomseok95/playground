package com.mongo.data.services

import com.mongo.data.models.CommentRequest
import com.mongo.data.models.Product
import com.mongo.data.models.ProductQuery
import com.mongo.data.models.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    fun findPage(
        query: ProductQuery,
    ): Page<Product> = productRepository.findQuery(query)

    fun save(product: Product) =
        productRepository.save(product)

    fun createComment(productId: String, commentRequest: List<CommentRequest>) {
        val product = (productRepository.findByIdOrNull(productId)
            ?: throw IllegalArgumentException(""))
        product.addComments(commentRequest)
        productRepository.save(product)
    }
}
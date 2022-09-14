package com.mongo.data.services

import com.mongo.data.models.CommentRequest
import com.mongo.data.models.Product
import com.mongo.data.models.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    fun findAll() = productRepository.findAll()

    fun save(product: Product) =
        productRepository.save(product)

    fun createComment(productId: String, commentRequest: List<CommentRequest>) {
        val product = (productRepository.findByIdOrNull(productId)
            ?: throw IllegalArgumentException(""))
        product.addComments(commentRequest)
        productRepository.save(product)
    }
}
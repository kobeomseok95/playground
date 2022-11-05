package com.mongo.data.controllers

import com.mongo.data.models.CommentRequest
import com.mongo.data.models.Product
import com.mongo.data.models.ProductRepository
import com.mongo.data.services.ProductService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
    private val productRepository: ProductRepository,
) {

    @PostMapping("/products")
    fun createProduct(@RequestBody product: Product) {
        productService.save(product)
    }

    @PostMapping("/products/{productId}/comments")
    fun createProductHistory(
        @PathVariable productId: String,
        @RequestBody commentRequest: List<CommentRequest>,
    ) {
        productService.createComment(productId, commentRequest);
    }
}
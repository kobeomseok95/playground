package com.mongo.data.controllers

import com.mongo.data.models.CommentRequest
import com.mongo.data.models.Product
import com.mongo.data.services.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping("/products")
    fun findAll() = productService.findAll()

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
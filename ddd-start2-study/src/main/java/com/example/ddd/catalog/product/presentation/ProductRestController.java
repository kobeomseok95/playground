package com.example.ddd.catalog.product.presentation;

import com.example.ddd.catalog.product.application.ProductCommandService;
import com.example.ddd.catalog.product.presentation.dto.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductRestController {

    private final ProductCommandService productCommandService;

    @PostMapping("")
    public void createProduct(@RequestBody CreateProductRequest createProductRequest) {
        productCommandService.create(createProductRequest.toRequestDto());
    }
}

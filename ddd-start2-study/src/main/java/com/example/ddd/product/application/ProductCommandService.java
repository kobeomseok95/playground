package com.example.ddd.product.application;

import com.example.ddd.product.application.dto.request.CreateProductRequestDto;
import com.example.ddd.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCommandService {

    private final ProductRepository productRepository;

    public void create(CreateProductRequestDto createProductRequestDto) {
        productRepository.save(createProductRequestDto.toEntity());
    }
}

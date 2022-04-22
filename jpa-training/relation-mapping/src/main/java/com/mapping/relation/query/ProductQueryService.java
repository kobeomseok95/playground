package com.mapping.relation.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductQueryService {

    private final ProductQueryRepository productQueryRepository;

    public ProductData getProduct(Long productId) {
        return productQueryRepository.findById(productId).orElseThrow();
    }

}

package com.mapping.relation.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCommandService {

    private final ProductCommandRepository productCommandRepository;

    public void setName(Long productId, String name) {
        Product product = productCommandRepository.findById(productId).orElseThrow();
        product.setName(name);
    }
}

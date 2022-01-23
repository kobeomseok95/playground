package com.mapping.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ProductRepository productRepository;

    @GetMapping("/test")
    public String test() {
        Product product = Product.builder().build();
        product.like(Like.builder().build());
        productRepository.save(product);
        return "완료";
    }
}

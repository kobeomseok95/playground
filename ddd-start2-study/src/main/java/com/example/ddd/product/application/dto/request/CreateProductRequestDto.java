package com.example.ddd.product.application.dto.request;

import com.example.ddd.product.domain.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequestDto {

    private String productName;

    public Product toEntity() {
        return Product.builder()
                .name(productName)
                .build();
    }
}

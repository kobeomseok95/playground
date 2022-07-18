package com.example.ddd.catalog.product.application.dto.request;

import com.example.ddd.catalog.product.domain.Product;
import com.example.ddd.common.domainmodel.Money;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductRequestDto {

    private String productName;
    private Long price;

    public Product toEntity() {
        return Product.builder()
                .name(productName)
                .price(Money.of(price))
                .build();
    }
}

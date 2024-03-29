package com.example.ddd.catalog.product.presentation.dto.request;

import com.example.ddd.catalog.product.application.dto.request.CreateProductRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    private String productName;
    private Long price;

    public CreateProductRequestDto toRequestDto() {
        return CreateProductRequestDto.builder()
                .productName(productName)
                .price(price)
                .build();
    }
}

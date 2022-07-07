package com.example.ddd.product.presentation.dto.request;

import com.example.ddd.product.application.dto.request.CreateProductRequestDto;
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

    public CreateProductRequestDto toRequestDto() {
        return CreateProductRequestDto.builder()
                .productName(productName)
                .build();
    }
}

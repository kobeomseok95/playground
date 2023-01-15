package com.pattern.design.creational.builder.example;

public class ProductDirector {

    private ProductBuilder productBuilder;

    public ProductDirector(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product createWithStock() {
        return productBuilder
                .id(1L)
                .name("재고 있는 상품")
                .category("책")
                .manageType(ManageType.WITH_STOCK)
                .stockQuantity(1L)
                .isStopped(false)
                .build();
    }

    public Product createWithoutStock() {
        return productBuilder
                .id(2L)
                .name("재고 없는 상품")
                .category("이용권")
                .manageType(ManageType.WITHOUT_STOCK)
                .stockQuantity(0L)
                .isStopped(false)
                .build();
    }
}

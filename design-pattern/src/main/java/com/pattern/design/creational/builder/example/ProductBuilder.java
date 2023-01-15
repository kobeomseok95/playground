package com.pattern.design.creational.builder.example;

public interface ProductBuilder {

    ProductBuilder id(Long id);
    ProductBuilder name(String name);
    ProductBuilder category(String category);
    ProductBuilder manageType(ManageType manageType);
    ProductBuilder stockQuantity(Long stockQuantity);
    ProductBuilder isStopped(boolean isStopped);
    Product build();
}

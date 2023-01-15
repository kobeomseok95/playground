package com.pattern.design.creational.builder.example;

public class Product {
    private Long id;                // 상품 ID
    private String name;            // 상품명
    private String category;        // 카테고리 명
    private ManageType manageType;  // 상품 유형 -> 재고가 있는 상품인지 없는 상품인지 구별
    private Long stockQuantity;          // 재고
    private boolean isStopped;      // 판매 중단 여부

    public Product(Long id, String name, String category, ManageType manageType, Long stockQuantity, boolean isStopped) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.manageType = manageType;
        this.stockQuantity = stockQuantity;
        this.isStopped = isStopped;
    }
}

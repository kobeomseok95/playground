package com.pattern.design.creational.builder.example;

public class WithoutStockProductBuilder implements ProductBuilder {
    private Long id;
    private String name;
    private String category;
    private ManageType manageType;
    private Long stockQuantity;
    private boolean isStopped;

    @Override
    public ProductBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder category(String category) {
        this.category = category;
        return this;
    }

    @Override
    public ProductBuilder manageType(ManageType manageType) {
        this.manageType = manageType;
        return this;
    }

    @Override
    public ProductBuilder stockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    @Override
    public ProductBuilder isStopped(boolean isStopped) {
        this.isStopped = isStopped;
        return this;
    }

    @Override
    public Product build() {
        return new Product(
                this.id,
                this.name,
                this.category,
                this.manageType,
                this.stockQuantity,
                this.isStopped
        );
    }
}

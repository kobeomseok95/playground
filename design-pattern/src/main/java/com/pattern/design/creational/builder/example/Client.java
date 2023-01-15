package com.pattern.design.creational.builder.example;

public class Client {
    public static void main(String[] args) {
        ProductDirector withStockProductDirector = new ProductDirector(new WithStockProductBuilder());
        Product withStock = withStockProductDirector.createWithStock();

        ProductDirector withoutStockProductDirector = new ProductDirector(new WithoutStockProductBuilder());
        Product withoutStock = withStockProductDirector.createWithStock();
    }
}

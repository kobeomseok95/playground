package com.pattern.design.creational.factorymethod._04_sample.v1;

public class ProductFactory {

    public static Product createProduct(String type, String name, int price) {
        // validate
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("상품 타입을 입력해주세요. book과 album이 있습니다.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름을 입력해주세요.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0원 이상이어야 합니다.");
        }

        // create
        Product product = null;
        if (type.equalsIgnoreCase("album")) {
            product = new Product(type, name, price);
        } else if (type.equalsIgnoreCase("book")) {
            product = new Product(type, name, price);
        } else {
            throw new IllegalArgumentException("존재하지 않는 상품 타입입니다.");
        }

        return product;
    }
}

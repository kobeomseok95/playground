package com.pattern.design.creational.factorymethod._04_sample.v2;

public interface ProductFactory {

    default Product createProduct(String type, String name, int price) {
        // 기본적인 검증 구간
        validateTypeIsBlank(type);
        validateNameIsBlank(name);
        validatePriceIsUnderZero(price);

        // 객체 생성 구간
        validateProductType(type);
        return createByType(type, name, price);
    }

    void validateTypeIsBlank(String type);
    void validateNameIsBlank(String name);
    void validatePriceIsUnderZero(int price);
    void validateProductType(String type);
    Product createByType(String type, String name, int price);
}

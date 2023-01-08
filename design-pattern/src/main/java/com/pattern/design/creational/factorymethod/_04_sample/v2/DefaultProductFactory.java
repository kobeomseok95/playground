package com.pattern.design.creational.factorymethod._04_sample.v2;

public abstract class DefaultProductFactory implements ProductFactory {
    @Override
    public void validateTypeIsBlank(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("상품 타입을 입력해주세요. book과 album이 있습니다.");
        }
    }

    @Override
    public void validateNameIsBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름을 입력해주세요.");
        }
    }

    @Override
    public void validatePriceIsUnderZero(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0원 이상이어야 합니다.");
        }
    }
}

package com.example.ddd.order.domain;

import com.example.ddd.product.domain.Product;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderLine {

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    // TODO: 2022/07/07 kobeomseok95 Money 클래스 생성
    @Column(name = "price")
    private Long price;

    @Column(name = "quantity")
    private int quantity;

    // TODO: 2022/07/07 kobeomseok95 Money 클래스 생성
    @Column(name = "total_price")
    private Long totalPrice;

    // TODO: 2022/07/07 kobeomseok95 ProductId를 참조하는건 어떨까?
    public static OrderLine of(Product product, Long price, int quantity) {
        return OrderLine.builder()
                .product(product)
                .price(price)
                .quantity(quantity)
                .totalPrice(quantity * price)
                .build();
    }
}

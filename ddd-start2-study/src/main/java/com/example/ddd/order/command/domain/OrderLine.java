package com.example.ddd.order.command.domain;

import com.example.ddd.common.domain.Money;
import com.example.ddd.common.domain.MoneyConverter;
import com.example.ddd.catalog.product.domain.Product;
import lombok.*;

import javax.persistence.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class OrderLine {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "total_price")
    private Money totalPrice;

    public static OrderLine to(Product product, int quantity) {
        return OrderLine.builder()
                .product(product)
                .quantity(quantity)
                .totalPrice(product.getPrice().multiply(quantity))
                .build();
    }
}

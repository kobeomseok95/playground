package com.example.ddd.order.domain;

import com.example.ddd.common.domainmodel.Money;
import com.example.ddd.common.domainmodel.MoneyConverter;
import com.example.ddd.product.domain.Product;
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

package com.example.ddd.product.domain;

import com.example.ddd.common.domainmodel.Money;
import com.example.ddd.common.domainmodel.MoneyConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "product_price")
    private Money price;
}

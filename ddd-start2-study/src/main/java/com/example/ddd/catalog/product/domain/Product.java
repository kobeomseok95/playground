package com.example.ddd.catalog.product.domain;

import com.example.ddd.common.domain.Money;
import com.example.ddd.common.domain.MoneyConverter;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "product_name")
    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "product_price")
    private Money price;

    @ElementCollection
    @CollectionTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Long> categoryIds;
}

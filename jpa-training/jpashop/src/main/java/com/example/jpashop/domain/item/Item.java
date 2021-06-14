package com.example.jpashop.domain.item;

import com.example.jpashop.domain.BaseEntity;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.dto.ItemDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder
@TableGenerator(
        name = "ITEM_GENERATOR",
        table = "ITEM_SEQUENCE",
        pkColumnName = "SEQUENCE_NUMBER",
        valueColumnName = "next_val",
        allocationSize = 1000
)
public abstract class Item extends BaseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "ITEM_GENERATOR"
    )
    @Column(name = "ITEM_ID")
    private Long id;

    // 영속성 전이
    @Builder.Default
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    private String name;
    private int price;
    private int stockQuantity;

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        if (this.stockQuantity < quantity) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        this.stockQuantity -= quantity;
    }

    public void addCategoryItem(CategoryItem categoryItem) {
        if (!this.getCategoryItems().contains(categoryItem)) {
            this.getCategoryItems().add(categoryItem);
        }
    }

    public <T extends ItemDto> void updateItem(T request) {
        this.name = request.getName();
        this.price = request.getPrice();
        this.stockQuantity = request.getStockQuantity();
    }
}

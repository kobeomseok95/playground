package com.example.jpashop.domain;

import com.example.jpashop.domain.item.Item;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    // 연관된 아이템 삭제
    @Builder.Default
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    // 자신의 테이블도 부모 자식 관계 형성 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    // 영속성 전이, 부모 카테고리 삭제시 연쇄 삭제
    @Builder.Default
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();

    public void addParent(Category parent) {
        this.parent = parent;
        parent.getChildren().add(this);
    }

    public void addCategoryItem(CategoryItem categoryItem) {
        if (!this.getCategoryItems().contains(categoryItem)) {
            this.getCategoryItems().add(categoryItem);
        }
    }
}

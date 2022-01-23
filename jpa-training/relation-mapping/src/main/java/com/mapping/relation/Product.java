package com.mapping.relation;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Builder.Default
    @OneToMany(
            mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    private List<ProductImage> images = new ArrayList<>();

    @Builder.Default
    @OneToMany(
            mappedBy = "product",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    private List<Like> likes = new ArrayList<>();

    public void like(Like target) {
        target.setProduct(this);
        likes.add(target);
    }

    public void unlike(Like target) {
        likes.removeIf(like -> like.getId().equals(target.getId()));
    }

    public void addImages(List<ProductImage> images) {
        this.images.addAll(images);
    }

    public void putImages(List<ProductImage> images) {
        this.images.clear();
        addImages(images);
    }

    public void removeImage(ProductImage target) {
        this.images.removeIf(target::isEqual);
    }
}

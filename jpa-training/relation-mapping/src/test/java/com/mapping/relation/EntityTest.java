package com.mapping.relation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EntityTest {

    @Autowired
    EntityManager entityManager;
    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("여러 장의 사진을 덮어씌울 때")
    void putImages() throws Exception {

        // given
        Product product = Product.builder().build();
        ProductImage image1 = ProductImage.builder().product(product).url("test1").build();
        ProductImage image2 = ProductImage.builder().product(product).url("test2").build();
        product.addImages(List.of(image1, image2));
        productRepository.save(product);
        entityManager.flush();
        entityManager.clear();

        // when
        Product findProduct = productRepository.findById(product.getId()).orElseThrow();
        ProductImage image3 = ProductImage.builder().url("test3").build();
        ProductImage image4 = ProductImage.builder().url("test4").build();
        findProduct.putImages(List.of(image3, image4));
        entityManager.flush();

        // then
        assertEquals(2, findProduct.getImages().size());
    }

    @Test
    @DisplayName("하나의 사진을 지울 때")
    void removeImage() throws Exception {

        // given
        Product product = Product.builder().build();
        ProductImage image1 = ProductImage.builder().product(product).url("test1").build();
        ProductImage image2 = ProductImage.builder().product(product).url("test2").build();
        product.addImages(List.of(image1, image2));
        productRepository.save(product);
        entityManager.flush();
        entityManager.clear();

        // when
        Product findProduct = productRepository.findById(product.getId()).orElseThrow();
        findProduct.removeImage(image1);
        entityManager.flush();

        // then
        assertEquals(1, findProduct.getImages().size());
    }
}

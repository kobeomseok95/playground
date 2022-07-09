package com.example.ddd.catalog.product.infrastructure;

import com.example.ddd.catalog.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductJpaRepository extends JpaRepository<Product, Long> {
}

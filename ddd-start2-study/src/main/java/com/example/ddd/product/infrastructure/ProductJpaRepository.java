package com.example.ddd.product.infrastructure;

import com.example.ddd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductJpaRepository extends JpaRepository<Product, Long> {
}

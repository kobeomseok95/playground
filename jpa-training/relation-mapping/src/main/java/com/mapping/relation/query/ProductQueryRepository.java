package com.mapping.relation.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<ProductData, Long> {
}

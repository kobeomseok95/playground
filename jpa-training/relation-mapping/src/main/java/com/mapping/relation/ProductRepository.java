package com.mapping.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join fetch ProductImage i where p.id = :id")
    Optional<Product> findWithImagesById(@Param("id") Long id);
}

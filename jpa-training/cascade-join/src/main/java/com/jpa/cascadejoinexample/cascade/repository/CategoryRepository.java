package com.jpa.cascadejoinexample.cascade.repository;

import com.jpa.cascadejoinexample.cascade.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // distinct 시 부모 객체가 겹치지 않게 조회한다.
    @Query("select distinct c from Category c join fetch c.items")
    List<Category> findAllCategoriesAndItems();


    @Query("select distinct c from Category c join fetch c.items where c.id = :categoryId")
    Category findByIdFetch(@Param("categoryId") Long categoryId);
}

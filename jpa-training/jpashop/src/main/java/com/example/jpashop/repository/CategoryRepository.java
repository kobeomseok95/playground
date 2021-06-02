package com.example.jpashop.repository;

import com.example.jpashop.domain.Category;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select distinct c from Category c join fetch c.children cc where c.parent is null")
    List<Category> findByParentIdIsNull();

    // left join시 명시
    @Query("select c from Category c left join fetch c.categoryItems ci where c.id = :id")
    Optional<Category> findByIdFetch(@Param("id") Long id);
}

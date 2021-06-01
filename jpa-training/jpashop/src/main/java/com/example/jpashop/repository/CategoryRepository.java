package com.example.jpashop.repository;

import com.example.jpashop.domain.Category;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select distinct c from Category c join fetch c.children cc where c.parent is null")
    List<Category> findByParentIdIsNull();
}

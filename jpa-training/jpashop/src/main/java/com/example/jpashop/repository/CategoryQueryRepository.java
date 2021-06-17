package com.example.jpashop.repository;

import com.example.jpashop.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryRepository {

    List<Category> findByParentIdIsNull();

    Optional<Category> findByIdFetch(Long id);
}

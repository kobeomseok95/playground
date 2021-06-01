package com.example.jpashop.service;

import com.example.jpashop.dto.CategoryDto;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);
}

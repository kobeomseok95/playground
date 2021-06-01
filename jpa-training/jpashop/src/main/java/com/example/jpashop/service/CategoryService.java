package com.example.jpashop.service;

import com.example.jpashop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);

    List<CategoryDto.ParentCategory> getCategories();
}

package com.example.jpashop.util;

import com.example.jpashop.domain.Category;
import com.example.jpashop.dto.CategoryDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {

    CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    Category categoryDtoToCategory(CategoryDto request);

    CategoryDto categoryToCategoryDto(Category category);
}

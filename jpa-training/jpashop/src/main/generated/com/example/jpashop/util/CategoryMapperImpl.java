package com.example.jpashop.util;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.Category.CategoryBuilder;
import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.dto.CategoryDto.CategoryDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-01T14:56:44+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryDtoToCategory(CategoryDto request) {
        if ( request == null ) {
            return null;
        }

        CategoryBuilder category = Category.builder();

        category.name( request.getName() );

        return category.build();
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.name( category.getName() );

        return categoryDto.build();
    }
}

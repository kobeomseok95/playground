package com.example.jpashop.util;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.Category.CategoryBuilder;
import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.dto.CategoryDto.CategoryDtoBuilder;
import com.example.jpashop.dto.CategoryDto.ChildrenCategories;
import com.example.jpashop.dto.CategoryDto.ChildrenCategories.ChildrenCategoriesBuilder;
import com.example.jpashop.dto.CategoryDto.ParentCategory;
import com.example.jpashop.dto.CategoryDto.ParentCategory.ParentCategoryBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-01T17:40:35+0900",
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

    @Override
    public List<ParentCategory> categoryListToCategoryDtoList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<ParentCategory> list = new ArrayList<ParentCategory>( categories.size() );
        for ( Category category : categories ) {
            list.add( categoryToParentCategory( category ) );
        }

        return list;
    }

    protected ChildrenCategories categoryToChildrenCategories(Category category) {
        if ( category == null ) {
            return null;
        }

        ChildrenCategoriesBuilder childrenCategories = ChildrenCategories.builder();

        if ( category.getId() != null ) {
            childrenCategories.id( String.valueOf( category.getId() ) );
        }
        childrenCategories.name( category.getName() );

        return childrenCategories.build();
    }

    protected List<ChildrenCategories> categoryListToChildrenCategoriesList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<ChildrenCategories> list1 = new ArrayList<ChildrenCategories>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryToChildrenCategories( category ) );
        }

        return list1;
    }

    protected ParentCategory categoryToParentCategory(Category category) {
        if ( category == null ) {
            return null;
        }

        ParentCategoryBuilder parentCategory = ParentCategory.builder();

        if ( category.getId() != null ) {
            parentCategory.id( String.valueOf( category.getId() ) );
        }
        parentCategory.name( category.getName() );
        parentCategory.children( categoryListToChildrenCategoriesList( category.getChildren() ) );

        return parentCategory.build();
    }
}

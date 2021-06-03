package com.example.jpashop.util;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.dto.CategoryDto.ChildrenCategories;
import com.example.jpashop.dto.CategoryDto.ParentCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-03T17:35:17+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryDtoToCategory(CategoryDto request) {
        if ( request == null ) {
            return null;
        }

        String name = null;

        name = request.getName();

        Long id = null;
        List<CategoryItem> categoryItems = null;
        Category parent = null;
        List<Category> children = null;

        Category category = new Category( id, name, categoryItems, parent, children );

        return category;
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setName( category.getName() );

        return categoryDto;
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

        ChildrenCategories childrenCategories = new ChildrenCategories();

        if ( category.getId() != null ) {
            childrenCategories.setId( String.valueOf( category.getId() ) );
        }
        childrenCategories.setName( category.getName() );

        return childrenCategories;
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

        ParentCategory parentCategory = new ParentCategory();

        if ( category.getId() != null ) {
            parentCategory.setId( String.valueOf( category.getId() ) );
        }
        parentCategory.setName( category.getName() );
        parentCategory.setChildren( categoryListToChildrenCategoriesList( category.getChildren() ) );

        return parentCategory;
    }
}

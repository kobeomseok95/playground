package com.example.jpashop.service;

import com.example.jpashop.domain.Category;
import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.CategoryMapper;
import com.example.jpashop.util.CategoryUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Spy
    CategoryRepository categoryRepository;
    @Spy
    CategoryMapper categoryMapper;
    @Spy
    CategoryUtil categoryUtil;

    @Spy
    @InjectMocks
    CategoryServiceImpl categoryService;

    @Test
    @DisplayName("카테고리 부모 없이 생성")
    void createCategory() throws Exception {

        // given
        CategoryDto request = CategoryDto.builder().name("내가부모").build();
        CategoryDto response = mock(CategoryDto.class);
        Category category = mock(Category.class);

        when(categoryMapper.categoryDtoToCategory(request)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryMapper.categoryToCategoryDto(category)).thenReturn(response);

        // when
        categoryService.createCategory(request);

        // then
        verify(categoryRepository).save(category);
        verify(categoryUtil).isPresentParentId(request);
        verify(categoryMapper).categoryDtoToCategory(request);
        verify(categoryMapper).categoryToCategoryDto(category);
    }

    @Test
    @DisplayName("부모가 있는 계층형 카테고리 생성")
    void createCategory2() throws Exception {

        // given
        CategoryDto request = CategoryDto.builder().name("자식").parentId("12").build();
        CategoryDto response = mock(CategoryDto.class);
        Category parent = Category.builder().id(1L).name("부모").build();
        Category child = Category.builder().build();

        when(categoryMapper.categoryDtoToCategory(request)).thenReturn(child);
        when(categoryUtil.isPresentParentId(request)).thenReturn(true);
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(parent));
        when(categoryRepository.save(child)).thenReturn(child);
        when(categoryMapper.categoryToCategoryDto(child)).thenReturn(response);

        // when
        categoryService.createCategory(request);

        // then
        verify(categoryMapper).categoryDtoToCategory(request);
        verify(categoryUtil).isPresentParentId(request);
        verify(categoryRepository).findById(anyLong());
//        verify(child).addParent(parent);
        verify(categoryRepository).save(child);
        verify(categoryMapper).categoryToCategoryDto(child);
        verify(response).setParentId(anyString());
    }

    @Test
    @DisplayName("카테고리 삭제")
    void deleteCategory() throws Exception {

        // given, when
        categoryService.deleteCategory("1");

        // then
        verify(categoryRepository).deleteById(anyLong());
    }

    @Test
    @DisplayName("모든 카테고리 찾기, 부모가 없는 것만 찾고 나머지는 List로 반환")
    void getCategories() throws Exception {

        // given, when
        categoryService.getCategories();

        // then
        verify(categoryRepository).findByParentIdIsNull();
    }
}
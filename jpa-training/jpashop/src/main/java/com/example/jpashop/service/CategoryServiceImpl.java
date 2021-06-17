package com.example.jpashop.service;

import com.example.jpashop.domain.Category;
import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.CategoryMapper;
import com.example.jpashop.util.CategoryUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryUtil categoryUtil;

    // 영속성 전이 테스트 해보기
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category createCategory = categoryMapper.categoryDtoToCategory(categoryDto);
        boolean isPresentParentId = categoryUtil.isPresentParentId(categoryDto);

        if (isPresentParentId) {
            Category parent = categoryRepository.findById(Long.parseLong(categoryDto.getParentId()))
                    .orElseThrow();
            createCategory.addParent(parent);
        }

        Category savedCategory = categoryRepository.save(createCategory);
        CategoryDto response = categoryMapper.categoryToCategoryDto(savedCategory);

        if (isPresentParentId) {
            response.setParentId(savedCategory.getParent().getId().toString());
        }
        return response;
    }

    // 일대다 다대일의 경우 OneToMany쪽 (지금 예제에서는 Item과 Category)
    // 에서 다 지워줘야 한다.
    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public List<CategoryDto.ParentCategory> getCategories() {
        List<Category> categories = categoryRepository.findByParentIdIsNull();
        return categoryMapper.categoryListToCategoryDtoList(categories);
    }
}

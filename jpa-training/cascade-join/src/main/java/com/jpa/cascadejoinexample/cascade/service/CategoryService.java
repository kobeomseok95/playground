package com.jpa.cascadejoinexample.cascade.service;

import com.jpa.cascadejoinexample.cascade.domain.Category;
import com.jpa.cascadejoinexample.cascade.domain.Item;
import com.jpa.cascadejoinexample.cascade.dto.CategoryItemDto;
import com.jpa.cascadejoinexample.cascade.dto.ItemDto;
import com.jpa.cascadejoinexample.cascade.repository.CategoryRepository;
import com.jpa.cascadejoinexample.cascade.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    public List<CategoryItemDto> getCategories() {
        List<Category> categories = categoryRepository.findAllCategoriesAndItems();
        return createCategoryItemDtoListResponse(categories);
    }

    public CategoryItemDto getCategories(String categoryId) {
        Long id = Long.parseLong(categoryId);
        Category category = categoryRepository.findByIdFetch(id);
        return createCategoryItemDtoResponse(category);
    }

    // cascade test
    public void createCategory(CategoryItemDto categoryItemDto) {
        Category category = Category.builder()
                .name(categoryItemDto.getName())
                .items(new ArrayList<>())
                .build();

        categoryItemDto.getItems().forEach(i ->
                category.getItems()
                        .add(Item.builder().name(i.getName()).category(category).build()));

        // 부모 객체인 카테고리를 생성하고 이 카테고리 객체에 필드 컬렉션인 items에 Item 객체들을 집어넣었다.
        // category 만 save 해줘도 item도 DB에 들어간다.
        categoryRepository.save(category);
    }

    // cascade test
    public void deleteCategory(String categoryId) {
        Long id = Long.parseLong(categoryId);
        categoryRepository.deleteById(id);
    }

    private List<CategoryItemDto> createCategoryItemDtoListResponse(List<Category> categories) {
        List<CategoryItemDto> result = new ArrayList<>();
        categories.forEach(c -> {
            CategoryItemDto categoryItemDto = CategoryItemDto.builder()
                    .name(c.getName())
                    .items(new ArrayList<>())
                    .build();

            c.getItems().forEach(i -> {
                categoryItemDto.getItems().add(ItemDto.builder().name(i.getName()).build());
            });

            result.add(categoryItemDto);
        });

        return result;
    }

    private CategoryItemDto createCategoryItemDtoResponse(Category categories) {
        List<ItemDto> items = new ArrayList<>();

        categories.getItems().forEach(i -> ItemDto.builder().name(i.getName()).build());

        return CategoryItemDto.builder()
                .name(categories.getName())
                .items(items)
                .build();
    }
}

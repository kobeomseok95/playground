package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieItemService implements ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ItemDto getItem(String itemId) {
        return null;
    }

    @Override
    public <T extends ItemDto> void createItem(T request) {

        Category category = categoryRepository.findByIdFetch(Long.parseLong(request.getCategoryId())).orElseThrow();
        Movie movie = itemMapper.map((ItemDto.MovieDto) request);
        CategoryItem categoryItem = CategoryItem.builder().category(category).item(movie).build();

        category.addCategoryItem(categoryItem);
        movie.addCategoryItem(categoryItem);
        itemRepository.save(movie);
    }

    @Override
    public void updateItem(ItemDto request) {

    }

    @Override
    public void deleteItem(ItemDto itemId) {

    }
}

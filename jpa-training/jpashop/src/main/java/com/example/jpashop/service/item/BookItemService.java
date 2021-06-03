package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookItemService implements ItemService {

    private final ItemMapper itemMapper;
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    @Override
    public ItemDto getItem(String itemId) {
        return null;
    }

    @Override
    public <T extends ItemDto> void createItem(T request) {

        Category category = categoryRepository.findByIdFetch(Long.parseLong(request.getCategoryId())).orElseThrow();
        Book book = itemMapper.map((ItemDto.BookDto) request);
        CategoryItem categoryItem = CategoryItem.builder().category(category).item(book).build();

        category.addCategoryItem(categoryItem);
        book.addCategoryItem(categoryItem);
        itemRepository.save(book);
    }

    @Override
    public void updateItem(ItemDto request) {

    }

    @Override
    public void deleteItem(ItemDto itemId) {

    }
}

package com.example.jpashop.service.item;

import com.example.jpashop.domain.Category;
import com.example.jpashop.domain.CategoryItem;
import com.example.jpashop.domain.item.Album;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.CategoryRepository;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.util.AlbumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class AlbumItemService implements ItemService{

    private final AlbumMapper albumMapper;
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ItemDto> getItems() {
        return null;
    }

    @Override
    public ItemDto getItem(String itemId) {
        return null;
    }

    @Override
    public <T extends ItemDto> void createItem(T request) {

        Category category = categoryRepository.findById(Long.parseLong(request.getCategoryId())).orElseThrow();
        Album album = albumMapper.albumDtoToAlbum((ItemDto.AlbumDto) request);
        CategoryItem categoryItem = CategoryItem.builder().category(category).item(album).build();

        category.addCategoryItem(categoryItem);
        album.addCategoryItem(categoryItem);
        itemRepository.save(album);
    }

    @Override
    public void updateItem(ItemDto request) {

    }

    @Override
    public void deleteItem(ItemDto itemId) {

    }
}

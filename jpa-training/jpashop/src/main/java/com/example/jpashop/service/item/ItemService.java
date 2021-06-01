package com.example.jpashop.service.item;

import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getItems();

    ItemDto getItem(String itemId);

    <T extends ItemDto> void createItem(T request);

    void updateItem(ItemDto request);

    void deleteItem(ItemDto itemId);

    default ItemDto.ItemType type() {
        if (this instanceof AlbumItemService) {
            return ItemDto.ItemType.ALBUM;
        } else if (this instanceof BookItemService) {
            return ItemDto.ItemType.BOOK;
        } else {
            return ItemDto.ItemType.MOVIE;
        }
    }
}

package com.example.jpashop.service.item;

import com.example.jpashop.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieItemService implements ItemService {


    @Override
    public List<ItemDto> getItems() {
        return null;
    }

    @Override
    public ItemDto getItem(String itemId) {
        return null;
    }

    @Override
    public void createItem(ItemDto request) {

    }

    @Override
    public void updateItem(ItemDto request) {

    }

    @Override
    public void deleteItem(ItemDto itemId) {

    }
}

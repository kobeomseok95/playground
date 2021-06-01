package com.example.jpashop.service;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemCRUDService {

    private final List<ItemService> itemServices;

    public void createItem(ItemDto request) {
        ItemService itemService = getItemService(request.getItemType());
        itemService.createItem(request);
    }

    private ItemService getItemService(ItemDto.ItemType itemType) {
        return itemServices
                .stream()
                .filter(x -> x.type() == itemType)
                .findFirst()
                .orElseThrow();
    }
}

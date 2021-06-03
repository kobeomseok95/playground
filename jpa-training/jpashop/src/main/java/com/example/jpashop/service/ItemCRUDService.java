package com.example.jpashop.service;

import com.example.jpashop.domain.item.Album;
import com.example.jpashop.domain.item.Book;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.domain.item.Movie;
import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.repository.ItemRepository;
import com.example.jpashop.service.item.ItemService;
import com.example.jpashop.util.ItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemCRUDService {

    private final List<ItemService> itemServices;
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    public void createItem(ItemDto request) {
        ItemService itemService = getItemService(request.getItemType());
        itemService.createItem(request);
    }

    public ItemDto getItem(String itemId) {
        Item item = itemRepository.findByIdFetch(Long.parseLong(itemId)).orElseThrow();
        return getItemDto(item);
    }

    private ItemDto getItemDto(Item item) {
        if (item instanceof Album) {
            return itemMapper.map((Album) item);
        } else if (item instanceof Book) {
            return itemMapper.map((Book) item);
        } else {
            return itemMapper.map((Movie) item);
        }
    }

    private ItemService getItemService(ItemDto.ItemType itemType) {
        return itemServices
                .stream()
                .filter(x -> x.type() == itemType)
                .findFirst()
                .orElseThrow();
    }
}

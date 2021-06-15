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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ItemDto> getItems(Pageable pageable) {

        return itemRepository.findAll(pageable).map(i -> {
            if (i instanceof Album) {
                return itemMapper.map((Album) i);
            } else if (i instanceof Book) {
                return itemMapper.map((Book) i);
            } else {
                return itemMapper.map((Movie) i);
            }
        });
    }

    public void createItem(ItemDto request) {
        ItemService itemService = getItemService(request.getItemType());
        itemService.createItem(request);
    }

    public ItemDto getItem(String itemId) {
        Item item = itemRepository.findByIdFetch(Long.parseLong(itemId)).orElseThrow();
        return getItemDto(item);
    }

    public void updateItem(String itemId, ItemDto request) {
        Item item = itemRepository.findById(Long.parseLong(itemId)).orElseThrow();
        updateItemType(item, request);
    }

    public void deleteItem(String itemId) {
        itemRepository.deleteById(Long.parseLong(itemId));
    }

    // TODO : 리팩토링 필요
    private void updateItemType(Item item, ItemDto request) {
        if (item instanceof Album && request instanceof ItemDto.AlbumDto) {
            ((Album) item).updateAlbum((ItemDto.AlbumDto) request);
        } else if (item instanceof Book && request instanceof ItemDto.BookDto) {
            ((Book) item).updateBook((ItemDto.BookDto) request);
        } else if (item instanceof Movie && request instanceof ItemDto.MovieDto){
            ((Movie) item).updateMovie((ItemDto.MovieDto) request);
        }
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

package com.example.jpashop.controller;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.service.ItemCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemCRUDService itemCRUDService;

    @GetMapping("/web")
    public ResponseEntity<Page<ItemDto>> getItemsWeb(Pageable pageable) {

        return ResponseEntity.ok(itemCRUDService.getItems(pageable));
    }

//    @GetMapping("/mobile")
//    public ResponseEntity<Slice<ItemDto>> getItemsMobile(Pageable pageable) {
//
//        return ResponseEntity.ok(itemCRUDService.getItems(pageable));
//    }

    @PostMapping("/")
    public String createItem(@RequestBody ItemDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<? extends ItemDto> getItem(@PathVariable("itemId") String itemId) {

        return ResponseEntity.ok(itemCRUDService.getItem(itemId));
    }

    @PatchMapping("/{itemId}")
    public String updateItem(@PathVariable("itemId") String itemId, @RequestBody ItemDto request) {

        itemCRUDService.updateItem(itemId, request);
        return "수정 완료";
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem(@PathVariable("itemId") String itemId) {

        itemCRUDService.deleteItem(itemId);
        return "삭제 완료";
    }
}

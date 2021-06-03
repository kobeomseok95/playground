package com.example.jpashop.controller;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.service.ItemCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/")
    public String createItem(@RequestBody ItemDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<? extends ItemDto> getItem(@PathVariable("itemId") String itemId) {

        return ResponseEntity.status(HttpStatus.OK).body(itemCRUDService.getItem(itemId));
    }

    @PatchMapping("/{itemId}")
    public String updateItem(@PathVariable("itemId") String itemId, @RequestBody ItemDto request) {

        itemCRUDService.updateItem(itemId, request);
        return "수정 완료";
    }
}

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

    @GetMapping("/{itemId}")
    public ResponseEntity<? extends ItemDto> getItem(@PathVariable("itemId") String itemId) {

        // itemType, categoryId가 나오지 않음
        return ResponseEntity.status(HttpStatus.OK).body(itemCRUDService.getItem(itemId));
    }

    @PostMapping("/")
    public String createItem(@RequestBody ItemDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }

//    @PostMapping("/book")
//    public String createItem(@RequestBody ItemDto.BookDto request) {
//
//        itemCRUDService.createItem(request);
//        return "생성 완료";
//    }
//
//    @PostMapping("/movie")
//    public String createItem(@RequestBody ItemDto.MovieDto request) {
//
//        itemCRUDService.createItem(request);
//        return "생성 완료";
//    }
}

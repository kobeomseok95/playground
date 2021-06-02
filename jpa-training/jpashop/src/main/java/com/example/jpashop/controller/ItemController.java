package com.example.jpashop.controller;

import com.example.jpashop.dto.ItemDto;
import com.example.jpashop.service.ItemCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemCRUDService itemCRUDService;

    @PostMapping("/album")
    public String createItem(@RequestBody ItemDto.AlbumDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }

    @PostMapping("/book")
    public String createItem(@RequestBody ItemDto.BookDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }

    @PostMapping("/movie")
    public String createItem(@RequestBody ItemDto.MovieDto request) {

        itemCRUDService.createItem(request);
        return "생성 완료";
    }
}

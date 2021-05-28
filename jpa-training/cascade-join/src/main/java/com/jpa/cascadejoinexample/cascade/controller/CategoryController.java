package com.jpa.cascadejoinexample.cascade.controller;

import com.jpa.cascadejoinexample.cascade.dto.CategoryItemDto;
import com.jpa.cascadejoinexample.cascade.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")    // 전체 카테고리와 거기 속한 아이템 조회
    public ResponseEntity<List<CategoryItemDto>> getCategories() {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")    // 하나의 카테고리와 거기 속한 아이템 조회
    public ResponseEntity<CategoryItemDto> getCategories(@PathVariable("categoryId") String categoryId) {

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories(categoryId));
    }

    @PostMapping("/")   // 카테고리만 등록
    public String createCategory(@RequestBody CategoryItemDto categoryItemDto) {

        categoryService.createCategory(categoryItemDto);
        return "카테고리 및 아이템 등록 완료";
    }

    @DeleteMapping("/{categoryId}") // 카테고리 삭제 및 거기에 속한 아이템 삭제
    public String deleteCategoryAndItems(@PathVariable("categoryId") String categoryId) {

        categoryService.deleteCategory(categoryId);
        return "카테고리 및 아이템 삭제 완료";
    }
}

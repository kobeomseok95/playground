package com.example.jpashop.controller;

import com.example.jpashop.dto.CategoryDto;
import com.example.jpashop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {

        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") String id) {

        categoryService.deleteCategory(id);
        return "삭제 완료";
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto.ParentCategory>> getCategories() {

        return ResponseEntity.ok(categoryService.getCategories());
    }
}

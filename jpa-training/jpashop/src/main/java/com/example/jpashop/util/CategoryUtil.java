package com.example.jpashop.util;

import com.example.jpashop.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryUtil {

    public boolean isPresentParentId(CategoryDto categoryDto) {
        return categoryDto.getParentId() != null && !categoryDto.getParentId().equals("");
    }
}

package com.example.jpashop.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CategoryDto {

    private String name;
    private String parentId;


    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor @Builder
    public static class ParentCategory {

        private String id;
        private String name;
        private List<ChildrenCategories> children;

    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor @Builder
    public static class ChildrenCategories {

        private String id;
        private String name;
    }
}

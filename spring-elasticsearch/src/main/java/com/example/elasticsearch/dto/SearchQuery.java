package com.example.elasticsearch.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SearchQuery {

    private String keyword;

    @Builder.Default
    private List<Long> categoryIdList = new ArrayList<>();

    private Long zoneId;

    private Integer minPrice;

    private Integer maxPrice;
}

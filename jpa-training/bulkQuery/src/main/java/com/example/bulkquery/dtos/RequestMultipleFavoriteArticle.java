package com.example.bulkquery.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class RequestMultipleFavoriteArticle {

    private List<Long> articleIdList = new ArrayList<>();
}

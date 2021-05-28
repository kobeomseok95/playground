package com.jpa.cascadejoinexample.cascade.dto;

import com.jpa.cascadejoinexample.cascade.domain.Item;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryItemDto {

    private String name;

    private List<ItemDto> items = new ArrayList<>();
}

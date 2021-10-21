package com.example.restdocs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetResponse {

    private String name;
    private int age;

    public static List<GetResponse> getResponseList() {
        return List.of(
                GetResponse.builder().name("테스트1").age(21).build(),
                GetResponse.builder().name("테스트2").age(22).build(),
                GetResponse.builder().name("테스트3").age(23).build());
    }
}

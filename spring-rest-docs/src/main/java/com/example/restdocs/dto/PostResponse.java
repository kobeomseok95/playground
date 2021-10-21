package com.example.restdocs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {

    private String message;

    public static PostResponse success() {
        return PostResponse.builder()
                .message("success")
                .build();
    }

    public static PostResponse fail() {
        return PostResponse.builder()
                .message("fail")
                .build();
    }
}

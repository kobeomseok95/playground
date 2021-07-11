package com.example.awsec2s3practice.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardResponseDto {

    private String id;
    private String title;
    private String text;
    private String imageURL;
}

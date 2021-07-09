package com.example.awsec2s3practice.dtos;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private String title;

    private String text;

    private MultipartFile files;
}

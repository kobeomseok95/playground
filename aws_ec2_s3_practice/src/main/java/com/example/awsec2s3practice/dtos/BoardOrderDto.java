package com.example.awsec2s3practice.dtos;

import lombok.*;
import net.bytebuddy.matcher.FilterableList;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class BoardOrderDto {

    private int order;
    private MultipartFile file;
}

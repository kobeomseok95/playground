package com.example.redisexample.vo;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FileVo {

    private String fileName;
    private String fileUrl;

    public static FileVo of(String originalFilename, String url) {
        return FileVo.builder()
                .fileName(originalFilename)
                .fileUrl(url)
                .build();
    }
}

package com.example.redisexample.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
@RedisHash(value = "board", timeToLive = 60)
public class Board {

    @Id
    private String id;
    private Info info;
    @Builder.Default
    private List<ContentRedis> contentList = new ArrayList<>();

    @JsonIgnore
    public List<String> getFileNames() {
        List<String> fileNames = new ArrayList<>();
        fileNames.add(this.getInfo().getProfileUrl());
        fileNames.addAll(this.getContentList().stream().map(ContentRedis::getFileUrl).collect(toList()));
        return fileNames;
    }

    public void setContentFile(List<FileVo> contentVoList) {
        for (int i = 0; i < contentVoList.size(); i++) {
            this.getContentList().get(i).fileUrl = contentVoList.get(i).getFileUrl();
        }
    }

    public void setProfile(List<FileVo> profileVo) {
        this.getInfo().profileUrl = profileVo.get(0).getFileUrl();
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class Info {
        private String name;
        private String nickname;
        private String profileUrl;
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class ContentRedis {
        private String title;
        private String text;
        private String fileUrl;
    }
}

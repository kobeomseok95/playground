package com.example.redisexample.vo;

import com.example.redisexample.dto.InfoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.matcher.FilterableList;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.*;

@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
@RedisHash(value = "board", timeToLive = 60 * 60 * 24 * 7)
public class BoardForm {

    @Id
    private String id;
    private Info info;
    @Builder.Default
    private List<Content> contentList = new ArrayList<>();
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();

    @JsonIgnore
    public List<String> getFilesNames() {
        List<String> fileNames = new ArrayList<>();
        fileNames.add(getInfo().getProfileUrl());
        fileNames.addAll(getContentList().stream().map(Content::getProfileUrl).collect(toList()));
        fileNames.addAll(getCommentList().stream().map(Comment::getProfileUrl).collect(toList()));
        return fileNames;
    }

    public void setContentFiles(List<MultipartFile> contentFiles) {
        for (int i = 0; i < contentFiles.size(); i++) {
            this.getContentList().get(i).setProfileUrl(contentFiles.get(i).getOriginalFilename() + UUID.randomUUID());
        }
    }

    public void setCommentFiles(List<MultipartFile> commentFiles) {
        for (int i = 0; i < commentFiles.size(); i++) {
            this.getCommentList().get(i).setProfileUrl(commentFiles.get(i).getOriginalFilename() + UUID.randomUUID());
        }
    }

    public void setInfo(InfoDto infoDto, String fileName) {
        this.getInfo().setName(infoDto.getName());
        this.getInfo().setNickname(infoDto.getNickname());
        this.getInfo().setProfileUrl(fileName);
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class Info {
        private String name;
        private String nickname;
        private String profileUrl;
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class Content {
        private String title;
        private String text;
        private String profileUrl;
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
    public static class Comment {
        private int no;
        private String comment;
        private String profileUrl;
    }
}

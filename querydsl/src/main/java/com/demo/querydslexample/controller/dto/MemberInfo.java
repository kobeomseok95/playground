package com.demo.querydslexample.controller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Getter @Setter
@NoArgsConstructor(access = PRIVATE) @Builder
public class MemberInfo {

        private String username;

        @Builder.Default
        private Set<AddressInfo> addressInfos = new LinkedHashSet<>();

        @Builder.Default
        private Set<ArticleInfo> articleInfos = new LinkedHashSet<>();

        @QueryProjection
        public MemberInfo(String username, Set<AddressInfo> addressInfos, Set<ArticleInfo> articleInfos) {
            this.username = username;
            this.addressInfos = addressInfos;
            this.articleInfos = articleInfos;
        }

    @Getter @Setter
    @NoArgsConstructor(access = PRIVATE) @Builder
    @EqualsAndHashCode(of = "fullAddress")
    public static class AddressInfo {
        private String fullAddress;

        @QueryProjection
        public AddressInfo(String fullAddress) {
            this.fullAddress = fullAddress;
        }
    }

    @Getter @Setter
    @NoArgsConstructor(access = PRIVATE) @Builder
    @EqualsAndHashCode(of = "title")
    public static class ArticleInfo {
        private String title;

        @QueryProjection
        public ArticleInfo(String title) {
            this.title = title;
        }
    }
}

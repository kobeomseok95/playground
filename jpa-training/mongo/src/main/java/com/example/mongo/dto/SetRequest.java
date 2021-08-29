package com.example.mongo.dto;

import lombok.*;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class SetRequest {

    @Builder.Default
    private LinkedHashSet<Info> idSet = new LinkedHashSet<>();

    public void sort() {
        idSet = idSet.stream()
                .sorted(Comparator.comparing(Info::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor @Builder
    public static class Info {
        private Long id;
        private String name;
        private String gender;
    }
}

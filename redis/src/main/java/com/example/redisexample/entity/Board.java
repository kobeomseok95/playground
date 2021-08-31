package com.example.redisexample.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED) @Builder
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "BOARD_ID")
    private Long id;

    @Embedded
    private Info info;

    @OneToMany(mappedBy = "board")
    @Builder.Default
    private List<Content> content = new ArrayList<>();
}

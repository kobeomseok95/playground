package com.example.redisexample.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity @Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED) @Builder
public class Content {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "CONTENT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String title;
    private String text;
}

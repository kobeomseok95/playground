package com.example.querytraining.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CommentEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "COMMENT_ID")
    private Long id;
    private String text;
    private int realOrder;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "POST_ID")
    private PostEntity postEntity;
}

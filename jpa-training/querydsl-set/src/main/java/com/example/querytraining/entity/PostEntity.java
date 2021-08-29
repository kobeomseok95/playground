package com.example.querytraining.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PostEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "POST_ID")
    private Long id;
    private String title;

    @OneToMany(mappedBy = "postEntity")
    @Builder.Default
    private List<CommentEntity> commentEntityList = new ArrayList<>();
}

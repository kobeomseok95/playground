package com.example.querydslExample.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "POST_ID")
    private Long id;
    private String title;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<Comment> commentList = new ArrayList<>();
}

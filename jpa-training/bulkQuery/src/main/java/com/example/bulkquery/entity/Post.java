package com.example.bulkquery.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Builder
public class Post extends Item{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "POST_ID")
    private Long id;

    private String name;
}

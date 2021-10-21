package com.example.flyway.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@Getter
public class Article {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "article_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false)
    private int viewCount;

    private String thumbnailUrl;
}

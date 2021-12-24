package com.demo.querydslexample.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Getter
public class Articles {

    @OneToMany(mappedBy = "member")
    @Builder.Default
    private List<Article> articles = new ArrayList<>();
}

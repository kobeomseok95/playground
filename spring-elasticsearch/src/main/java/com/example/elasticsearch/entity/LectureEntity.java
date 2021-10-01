package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity @Getter
@NoArgsConstructor(access = PROTECTED) @AllArgsConstructor(access = PROTECTED) @Builder
public class LectureEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "lecture_id")
    private Long id;

    private String imageUrl;
    private String title;
    private String description;
    private String finishedProductText;
    private int regularPrice;
    private int priceOne;
    private int priceTwo;
    private int priceThree;
    private int priceFour;

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.example.elasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.Instant;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.data.elasticsearch.annotations.DateFormat.basic_date_time;

@Getter
@NoArgsConstructor(access = PRIVATE) @AllArgsConstructor(access = PRIVATE) @Builder
@Document(indexName = "lecture")
@Setting(settingPath = "/elasticsearch/lecture-settings.json")
@Mapping(mappingPath = "/elasticsearch/lecture-mappings.json")
public class LectureDocument {

    /**
     *      TODO : 키워드는 title, description, finishedProductText 들을 기반으로!
     *          위치는 선택된 것만
     *          카테고리 id는 포함된 것만
     *          가격은 50000 범위로 검색
     *          페이징
     */
    @Id
    private String id;

    @Field(type = FieldType.Long)
    private Long lectureId;

    @Field(type = FieldType.Text)
    private String imageUrl;

    @Field(type = FieldType.Text, analyzer = "word_analyzer")
    private String title;

    @Field(type = FieldType.Text, analyzer = "word_analyzer")
    private String description;

    @Field(type = FieldType.Text, analyzer = "word_analyzer")
    private String finishedProductText;

    @Field(type = FieldType.Long)
    private Long zoneId;

    @Field(type = FieldType.Long)
    private Long categoryId;

    @Field(type = FieldType.Integer)
    private Long regularPrice;

    @Field(type = FieldType.Integer)
    private Long priceOne;

    @Field(type = FieldType.Integer)
    private Long priceTwo;

    @Field(type = FieldType.Integer)
    private Long priceThree;

    @Field(type = FieldType.Integer)
    private Long priceFour;

    @CreatedDate
    @Field(type = FieldType.Date, format = basic_date_time)
    private Instant createdDate;

    @LastModifiedDate
    @Field(type = FieldType.Date, format = basic_date_time)
    private Instant lastModifiedDate;
}

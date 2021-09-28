package com.example.elasticsearch.domain;

import lombok.*;
import org.elasticsearch.geometry.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import static lombok.AccessLevel.*;
import static org.springframework.data.elasticsearch.annotations.DateFormat.*;

@Document(indexName = "person")
@Getter @NoArgsConstructor(access = PRIVATE) @AllArgsConstructor(access = PRIVATE) @Builder
public class Person {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Keyword)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Integer)
    private int height;

    @Field(type = FieldType.Integer)
    private int weight;

    @Field(type = FieldType.Date, format = date_hour_minute_second_millis)
    private LocalDateTime joinDateTime;

    @CreatedDate
    @Field(type = FieldType.Date, format = basic_date_time)
    private Instant createdDate;

    private GeoPoint location;
}

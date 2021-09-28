package com.example.elasticsearch.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Getter @Setter
@Document(indexName = "reservation")
@Setting(settingPath = "elastic-setting.json")
public class ReservationIndex {

    @Id
    @Field(type = FieldType.Long)
    private Long reservationId;

    @Field(type = FieldType.Keyword)
    private String type;

    @Field(type = FieldType.Keyword)
    private String serviceId;

    @GeoPointField
    private GeoPoint location;

    @Field(type = FieldType.Date)
    private String startDate;
}

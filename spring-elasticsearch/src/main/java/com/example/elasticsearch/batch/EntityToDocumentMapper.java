package com.example.elasticsearch.batch;

import com.example.elasticsearch.domain.LectureDocument;
import com.example.elasticsearch.entity.LectureEntity;

public class EntityToDocumentMapper {

    public static LectureDocument toDocument(LectureEntity entity) {
        return LectureDocument.builder()
                .lectureId(entity.getId())
                .imageUrl(entity.getImageUrl())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .finishedProductText(entity.getFinishedProductText())
                .regularPrice(Integer.toUnsignedLong(entity.getRegularPrice()))
                .priceOne(Integer.toUnsignedLong(entity.getPriceOne()))
                .priceTwo(Integer.toUnsignedLong(entity.getPriceTwo()))
                .priceThree(Integer.toUnsignedLong(entity.getPriceThree()))
                .priceFour(Integer.toUnsignedLong(entity.getPriceFour()))
                .build();
    }
}

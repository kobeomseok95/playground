package com.example.redisexample.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME
        // 이 설정이 들어가면, super 와 그것을 상속받는 객체에 중복값이 안나온다
        , include = JsonTypeInfo.As.EXISTING_PROPERTY
        //json 안의 어떤 키값으로 타입을 결정할지 키값
        , property = "createType",
        visible = true
        // 키값이 없을 경우 디폴트로 설정할 class
        /*, defaultImpl = SimpleReservationBase.class*/)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "INFO", value = InfoDto.class),
        @JsonSubTypes.Type(name = "CONTENT", value = ContentDto.class),
        @JsonSubTypes.Type(name = "COMMENT", value = CommentDto.class)
})
@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @SuperBuilder
public class Create {

    private CreateType createType;

    @Getter
    @AllArgsConstructor
    public enum CreateType {
        INFO, CONTENT, COMMENT;
    }
}

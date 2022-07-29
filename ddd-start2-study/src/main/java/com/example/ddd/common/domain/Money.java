package com.example.ddd.common.domain;

import lombok.*;

/**
 *  Money는 돈 자체이기 때문에 여러 엔티티에서 참조할 수 있다.
 *  그리고 단일 컬럼이다.
 *  따라서 Embeddable을 사용하지 말고 참조하는 객체에서 @Column을 통해 정의하기
 */
@Value
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode(of = "value")
public class Money {

    private final Long value;

    public static Money of(Long value) {
        return Money.builder()
                .value(value)
                .build();
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}

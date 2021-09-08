package com.example.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author beomseok
 *
 * 가격이 특정 범위일 때 상환 효율과 상환금액을 가지는 클래스
 */
@Getter
@AllArgsConstructor
public class BrokerageRule {

    private Double brokeragePercent;
    private Long limitAmount;

    public Long calculateMaxBrokerage(Long price) {
        if (limitAmount == null) {
            return multiplyPercent(price);
        }
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(Math.floor(brokeragePercent / 100 * price)).longValue();
    }
}

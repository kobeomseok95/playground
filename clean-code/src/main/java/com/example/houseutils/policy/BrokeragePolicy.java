package com.example.houseutils.policy;

import com.example.houseutils.exception.HouseUtilsException;

import java.util.List;

import static com.example.houseutils.exception.ErrorCode.INTERNAL_ERROR;

public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {
        return getRules()
                .stream()
                .filter(rule -> price < rule.getLessThan())
                .findFirst()
                .orElseThrow(() -> new HouseUtilsException(INTERNAL_ERROR))
                .calculateMaxBrokerage(price);
    }
}

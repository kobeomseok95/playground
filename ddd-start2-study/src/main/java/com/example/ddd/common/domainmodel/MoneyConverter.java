package com.example.ddd.common.domainmodel;

import javax.persistence.AttributeConverter;

public class MoneyConverter implements AttributeConverter<Money, Long> {

    @Override
    public Long convertToDatabaseColumn(Money entityAttribute) {
        return entityAttribute == null ? null : entityAttribute.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Long dbData) {
        return dbData == null ? null : Money.of(dbData);
    }
}

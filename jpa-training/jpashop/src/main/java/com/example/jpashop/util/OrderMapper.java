package com.example.jpashop.util;

import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.dto.OrderDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Mappings({
        @Mapping(source = "city", target = "address.city"),
        @Mapping(source = "street", target = "address.street"),
        @Mapping(source = "zipcode", target = "address.zipcode")
    })
    Delivery toDeliveryAddress(OrderDto.AddressDto source);

    OrderItem toOrderItem(OrderDto.OrderItemDto source);
}

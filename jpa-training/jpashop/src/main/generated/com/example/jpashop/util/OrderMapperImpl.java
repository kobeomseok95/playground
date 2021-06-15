package com.example.jpashop.util;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Delivery;
import com.example.jpashop.domain.DeliveryStatus;
import com.example.jpashop.domain.Order;
import com.example.jpashop.domain.OrderItem;
import com.example.jpashop.domain.item.Item;
import com.example.jpashop.dto.OrderDto.AddressDto;
import com.example.jpashop.dto.OrderDto.OrderItemDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-15T12:29:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Delivery toDeliveryAddress(AddressDto source) {
        if ( source == null ) {
            return null;
        }

        Address address = null;

        address = addressDtoToAddress( source );

        Long id = null;
        Order order = null;
        DeliveryStatus status = null;

        Delivery delivery = new Delivery( id, order, address, status );

        return delivery;
    }

    @Override
    public OrderItem toOrderItem(OrderItemDto source) {
        if ( source == null ) {
            return null;
        }

        int count = 0;

        count = source.getCount();

        Long id = null;
        Order order = null;
        Item item = null;

        OrderItem orderItem = new OrderItem( id, order, item, count );

        return orderItem;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        String city = null;
        String street = null;
        String zipcode = null;

        city = addressDto.getCity();
        street = addressDto.getStreet();
        zipcode = addressDto.getZipcode();

        Address address = new Address( city, street, zipcode );

        return address;
    }
}

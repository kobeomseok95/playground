package com.example.jpashop.domain;

import com.example.jpashop.dto.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    @DisplayName("배송 생성")
    void createDelivery() throws Exception {

        OrderDto.AddressDto request = OrderDto.AddressDto.builder()
                .city("시티").street("스트릿").zipcode("집코드").build();

        // when
        Delivery delivery = Delivery.createDelivery(request);

        // then
        assertAll(
                () -> assertEquals(delivery.getAddress().getCity(), request.getCity()),
                () -> assertEquals(delivery.getAddress().getStreet(), request.getStreet()),
                () -> assertEquals(delivery.getAddress().getZipcode(), request.getZipcode()),
                () -> assertEquals(delivery.getStatus(), DeliveryStatus.READY));
    }
}
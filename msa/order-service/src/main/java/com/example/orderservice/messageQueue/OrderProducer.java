package com.example.orderservice.messageQueue;

import com.example.orderservice.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final List<Field> fields = Arrays.asList(
            Field.builder().type("string").optional(true).field("order_id").build(),
            Field.builder().type("string").optional(true).field("user_id").build(),
            Field.builder().type("string").optional(true).field("product_id").build(),
            Field.builder().type("int32").optional(true).field("quantity").build(),
            Field.builder().type("int32").optional(true).field("unit_price").build(),
            Field.builder().type("int32").optional(true).field("total_price").build());
    private final Schema schema = Schema.builder()
            .type("struct")
            .fields(fields)
            .optional(false)
            .name("orders").build();

    public OrderDto send(String topic, OrderDto orderDto) throws JsonProcessingException {

        Payload payload = Payload.builder()
                .order_id(orderDto.getOrderId())
                .user_id(orderDto.getUserId())
                .product_id(orderDto.getProductId())
                .quantity(orderDto.getQuantity())
                .unit_price(orderDto.getUnitPrice())
                .total_price(orderDto.getTotalPrice())
                .build();

        KafkaOrderDto kafkaOrderDto = KafkaOrderDto.builder()
                .schema(schema)
                .payload(payload)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = objectMapper.writeValueAsString(kafkaOrderDto);
        kafkaTemplate.send(topic, jsonInString);
        log.info("Order Producer sent data from the Order micro-service : " + kafkaOrderDto);

        return orderDto;
    }
}

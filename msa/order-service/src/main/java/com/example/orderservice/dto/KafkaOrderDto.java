package com.example.orderservice.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KafkaOrderDto implements Serializable {

    private Schema schema;
    private Payload payload;
}

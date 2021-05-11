package com.example.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog implements Serializable {

    private String productId;
    private String productName;
    private int unitPrice;
    private int stock;
    private LocalDateTime createdAt;
}

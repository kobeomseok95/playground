package com.example.batch.job.migration.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderItem;
    private Integer price;
    private Date orderDate;
    private Date accountDate;

    public Accounts(Orders order) {
        this.id = order.getId();
        this.orderItem = order.getOrderItem();
        this.price = order.getPrice();
        this.orderDate = order.getOrderDate();
        this.accountDate = new Date();
    }
}

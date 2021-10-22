package com.example.flyway.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Customer {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "customer_id")
    private Long id;

    private String name;
}

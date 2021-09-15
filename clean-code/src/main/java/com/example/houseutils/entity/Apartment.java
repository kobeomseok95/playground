package com.example.houseutils.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
public class Apartment {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "APARTMENT_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long price;
}

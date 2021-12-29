package com.example.solid.modules.unit.seat;

import com.example.solid.modules.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class Seat extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "SEAT_ID")
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private int seatNumber;
}

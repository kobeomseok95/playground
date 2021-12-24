package com.example.solid.modules.voucher.domain;

import com.example.solid.modules.BaseEntity;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
public class Voucher extends BaseEntity {

    @Id @GeneratedValue(strategy = IDENTITY) @Column(name = "VOUCHER_ID")
    private Long id;

    @Column(nullable = false)
    private String passName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int time;
}

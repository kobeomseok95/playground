package com.example.bulkquery.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
@Builder
public class Coupon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "COUPON_ID")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;
}

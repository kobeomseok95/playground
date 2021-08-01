package com.example.bulkquery.entity;


import lombok.*;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Builder
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ADDRESS_ID")
    private Long id;
    private String fullAddress;

    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}

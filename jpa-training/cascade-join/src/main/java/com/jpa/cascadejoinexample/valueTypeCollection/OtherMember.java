package com.jpa.cascadejoinexample.valueTypeCollection;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OtherMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OTHER_MEMBER_ID")
    private Long id;

    @Embedded
    private Address address;
}

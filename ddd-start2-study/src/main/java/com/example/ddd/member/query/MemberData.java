package com.example.ddd.member.query;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Getter
public class MemberData {

    @Id
    @Column(name = "member_id")
    private Long memberId;

    private String memberName;
}

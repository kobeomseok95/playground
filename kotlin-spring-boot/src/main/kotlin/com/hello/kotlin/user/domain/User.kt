package com.hello.kotlin.user.domain

import javax.persistence.*

// TODO: 2022/07/23 연관 관계 매핑해보기
@Entity
@Table(name = "USERS")
class User (
    var name: String,
    var age: Int,
    var address: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    val id: Long? = null
}
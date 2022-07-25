package com.hello.kotlin.user.domain

import javax.persistence.*

@Entity
@Table(name = "USERS")
class User (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    val id: Long? = null,
    var name: String,
    var age: Int,
    var address: String,
) {

    fun updateInfo(name: String, age: Int, address: String) {
        this.name = name
        this.age = age
        this.address = address
    }
}

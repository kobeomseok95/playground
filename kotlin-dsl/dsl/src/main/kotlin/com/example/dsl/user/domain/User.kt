package com.example.dsl.user.domain

data class User(
    val id: Id? = null,
    val name: String,
    val email: String,
    val nickname: String,
    val password: String,
) {
    data class Id(
        val id: Long,
    )
}

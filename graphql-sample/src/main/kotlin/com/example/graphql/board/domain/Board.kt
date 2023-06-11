package com.example.graphql.board.domain

data class Board(
    val id: Long? = null,
    val title: String,
    val content: String,
)

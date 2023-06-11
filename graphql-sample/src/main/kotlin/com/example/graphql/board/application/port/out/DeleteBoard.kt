package com.example.graphql.board.application.port.out

interface DeleteBoard {
    fun deleteBoard(id: Long)
}
package com.example.graphql.board.application.port.out

import com.example.graphql.board.domain.Board
import org.springframework.data.domain.Page

interface GetBoard {
    fun findPage(query: BoardQuery): Page<Board>
    fun findById(id: Long): Board
    fun findAll(): List<Board>
}

data class BoardQuery(
    val ids: List<Long>,
    val page: Long,
    val size: Int,
)

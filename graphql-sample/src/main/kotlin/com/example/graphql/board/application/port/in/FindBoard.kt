package com.example.graphql.board.application.port.`in`

import com.example.graphql.board.application.port.out.BoardQuery
import com.example.graphql.board.domain.Board
import org.springframework.data.domain.Page

interface FindBoard {
    fun findPage(query: BoardQuery): Page<Board>
    fun findById(id: Long): Board
    fun findAll(): List<Board>
}
package com.example.graphql.board.adapter.port.`in`.graphql

import com.example.graphql.board.application.port.`in`.FindBoard
import com.example.graphql.board.application.port.out.BoardQuery
import com.example.graphql.board.domain.Board
import org.springframework.data.domain.Page
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BoardController(
    private val findBoard: FindBoard,
) {
    @QueryMapping
    fun findById(@Argument id: String): Board = findBoard.findById(id.toLong())

    @QueryMapping
    fun findAll(): List<Board> = findBoard.findAll()

    @QueryMapping
    fun findPage(
        ids: List<Long>,
        page: Long,
        size: Int,
    ): Page<Board> = BoardQuery(
        ids = ids,
        page = page,
        size = size,
    ).run(findBoard::findPage)
}

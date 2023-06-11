package com.example.graphql.board.application.usecase

import com.example.graphql.board.application.port.`in`.FindBoard
import com.example.graphql.board.application.port.out.BoardQuery
import com.example.graphql.board.application.port.out.GetBoard
import com.example.graphql.board.domain.Board
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
internal class BoardQueryService(
    private val getBoard: GetBoard,
) : FindBoard {
    override fun findPage(query: BoardQuery): Page<Board> = getBoard.findPage(query)

    override fun findById(id: Long): Board = getBoard.findById(id)

    override fun findAll(): List<Board> = getBoard.findAll()
}
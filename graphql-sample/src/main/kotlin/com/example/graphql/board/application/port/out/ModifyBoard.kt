package com.example.graphql.board.application.port.out

import com.example.graphql.board.domain.Board

interface ModifyBoard {
    fun modify(board: Board): Board
}
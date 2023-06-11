package com.example.graphql.board.application.port.out

import com.example.graphql.board.domain.Board

interface SaveBoard {
    fun saveBoard(board: Board): Board
}
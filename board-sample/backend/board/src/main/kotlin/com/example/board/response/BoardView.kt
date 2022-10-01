package com.example.board.response

import com.example.board.entity.Board

data class BoardView(
    val id: Long,
    val title: String,
    val content: String,
    val authorName: String,
) {
    companion object {
        fun of(board: Board): BoardView = with(board) {
            BoardView(
                id = this.id!!,
                title = this.boardAttribute.title,
                content = this.boardAttribute.content,
                authorName = this.boardAttribute.authorName,
            )
        }
    }
}
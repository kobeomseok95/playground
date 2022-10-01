package com.example.board.request

import com.example.board.entity.BoardCommand

data class BoardCommand(
    val title: String,
    val content: String,
) {
    fun toCommand(): BoardCommand.Modify = BoardCommand.Modify(
        title = this.title,
        content = this.content,
    )
}
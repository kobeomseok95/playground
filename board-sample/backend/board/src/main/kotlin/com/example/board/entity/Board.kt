package com.example.board.entity

import java.lang.Compiler.command
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Embedded
    var boardAttribute: BoardAttribute,
) {
    fun modify(command: BoardCommand.Modify): Board {
        val newBoardAttribute = with(command) {
            BoardAttribute(
                title = this.title,
                content = this.content,
                authorName = this@Board.boardAttribute.authorName,
            )
        }
        this.boardAttribute = newBoardAttribute
        return this
    }
}

@Embeddable
data class BoardAttribute(
    @Column(name = "title")
    val title: String,
    @Column(name = "content")
    val content: String,
    @Column(name = "author_name")
    val authorName: String,
)

sealed class BoardCommand {
    data class Modify(
        val title: String,
        val content: String,
    ): BoardCommand()
}

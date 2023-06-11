package com.example.graphql.board.adapter.port.out.persistence

import com.example.graphql.board.domain.Board
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "board")
@Entity
class BoardJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
) {
    val identifier
        get() = requireNotNull(id) { "Not Persisted ID" }

    fun modify(board: Board): BoardJpaEntity = BoardJpaEntity(
        title = title,
        content = content,
    )
}

package com.example.graphql.board.adapter.port.out.persistence

import com.example.graphql.board.adapter.port.out.persistence.BoardJpaEntity
import com.example.graphql.board.domain.Board
import org.springframework.stereotype.Component

@Component
internal class BoardMapper {
    fun toJpaEntity(board: Board): BoardJpaEntity = with(board) {
        BoardJpaEntity(
            id = id,
            title = title,
            content = content,
        )
    }

    fun toDomainEntity(boardJpaEntity: BoardJpaEntity): Board = with(boardJpaEntity) {
        Board(
            id = identifier,
            title = title,
            content = content,
        )
    }
}

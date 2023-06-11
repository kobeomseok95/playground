package com.example.graphql.board.adapter.port.out.persistence

import com.example.graphql.board.application.port.out.BoardQuery
import com.example.graphql.board.application.port.out.DeleteBoard
import com.example.graphql.board.application.port.out.GetBoard
import com.example.graphql.board.application.port.out.ModifyBoard
import com.example.graphql.board.application.port.out.SaveBoard
import com.example.graphql.board.domain.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class BoardAdapter(
    private val boardJpaRepository: BoardJpaRepository,
    private val boardMapper: BoardMapper,
) : DeleteBoard, ModifyBoard, SaveBoard, GetBoard {
    override fun deleteBoard(id: Long) {
        boardJpaRepository.deleteById(id)
    }

    override fun modify(board: Board): Board =
        boardJpaRepository.findByIdOrNull(board.id)
            ?.modify(board)
            ?.let { boardMapper.toDomainEntity(it) }
            ?: throw RuntimeException("Not Found Board")

    override fun saveBoard(board: Board): Board =
        boardMapper.toJpaEntity(board)
            .let { boardJpaRepository.save(it) }
            .let { boardMapper.toDomainEntity(it) }

    override fun findPage(query: BoardQuery): Page<Board> =
        boardJpaRepository.findAll(PageRequest.of(query.page.toInt(), query.size))
            .map { boardMapper.toDomainEntity(it) }

    override fun findById(id: Long): Board = boardJpaRepository.findByIdOrNull(id)
        ?.let { boardMapper.toDomainEntity(it) }
        ?: throw RuntimeException("Not Found Board")

    override fun findAll(): List<Board> = boardJpaRepository
        .findAll()
        .map { boardJpaEntity ->
            boardMapper.toDomainEntity(boardJpaEntity)
        }
}

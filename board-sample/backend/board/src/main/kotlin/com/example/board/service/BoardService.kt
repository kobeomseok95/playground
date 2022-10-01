package com.example.board.service

import com.example.board.request.BoardCommand
import com.example.board.repository.BoardRepository
import com.example.board.response.BoardView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    @Transactional(readOnly = true)
    fun findPage(pageable: Pageable): Page<BoardView> = boardRepository.findAll(pageable)
        .map { BoardView.of(it) }

    @Transactional(readOnly = true)
    fun findById(id: Long): BoardView? = boardRepository.findByIdOrNull(id)
        ?.run(BoardView.Companion::of)

    @Transactional(readOnly = false)
    fun modify(id: Long, command: BoardCommand): BoardView = boardRepository.findByIdOrNull(id)
        ?.run { this.modify(command.toCommand()) }
        ?.run(BoardView.Companion::of)
        ?: throw IllegalArgumentException("찾는 게시글이 없습니다.")

    @Transactional(readOnly = false)
    fun delete(id: Long) {
        boardRepository.deleteById(id)
    }
}
package com.example.board.controller

import com.example.board.request.BoardCommand
import com.example.board.response.BoardView
import com.example.board.service.BoardService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/boards")
class BoardController(
    private val boardService: BoardService,
) {

    @GetMapping("")
    fun findPage(
        @PageableDefault(page = 0, size = 10) pageable: Pageable,
    ): Page<BoardView> = boardService.findPage(pageable)

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): BoardView? = boardService.findById(id)

    @PutMapping("/{id}")
    fun modify(
        @PathVariable id: Long,
        @RequestBody command: BoardCommand,
    ): BoardView = boardService.modify(id, command)

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long,
    ) {
        boardService.delete(id)
    }
}
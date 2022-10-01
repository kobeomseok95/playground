package com.example.board

import com.example.board.entity.Board
import com.example.board.entity.BoardAttribute
import com.example.board.repository.BoardRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class BoardApplication

fun main(args: Array<String>) {
    runApplication<BoardApplication>(*args)
}

@Component
class BoardCommand(
    private val boardRepository: BoardRepository,
): CommandLineRunner {

    override fun run(vararg args: String?) {
        for (i in 0 until 30) {
            boardRepository.save(
                Board(
                    boardAttribute = BoardAttribute(
                        title = (i + 1).toString() + "번째 글",
                        content = (i + 1).toString() + "번째 내용",
                        authorName = "글쓴이",
                    )
                )
            )
        }
    }
}

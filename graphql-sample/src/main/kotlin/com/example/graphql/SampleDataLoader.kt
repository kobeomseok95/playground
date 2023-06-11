package com.example.graphql

import com.example.graphql.board.application.port.out.SaveBoard
import com.example.graphql.board.domain.Board
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SampleDataLoader(
    private val saveBoard: SaveBoard,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        // temporary data
        Board(
            title = "Test1",
            content = "Test1",
        ).apply(saveBoard::saveBoard)
        Board(
            title = "Test2",
            content = "Test2",
        ).apply(saveBoard::saveBoard)
        Board(
            title = "Test3",
            content = "Test3",
        ).apply(saveBoard::saveBoard)
    }
}
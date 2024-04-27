package leetcode.medium

import java.util.LinkedList

class `1926` {

    data class Coordinate(
        val row: Int,
        val column: Int,
        val movedCount: Int,
    )

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        return bfs(maze, entrance)
    }

    private fun bfs(maze: Array<CharArray>, entrance: IntArray): Int {
        val maxRow = maze.size
        val maxColumn = maze[0].size
        val visited = Array(maxRow) { BooleanArray(maxColumn) }
        val queue = LinkedList<Coordinate>().apply {
            val start = Coordinate(entrance[0], entrance[1], 0)
            add(start)
            visited[start.row][start.column] = true
        }

        while (queue.isNotEmpty()) {
            val current = queue.pop()

            if (isExit(current, entrance, maxRow, maxColumn)) {
                return current.movedCount
            }

            val nextCoordinates = getNextCoordinates(current, maze, visited, maxRow, maxColumn)
            queue.addAll(nextCoordinates)
            nextCoordinates.forEach { coordinate -> visited[coordinate.row][coordinate.column] = true }
        }

        return -1
    }

    private fun isExit(coordinate: Coordinate, entrance: IntArray, maxRow: Int, maxColumn: Int): Boolean {
        if (coordinate.row == entrance[0] && coordinate.column == entrance[1]) {
            return false
        }
        return coordinate.row == 0 || coordinate.row == maxRow - 1 ||
            coordinate.column == 0 || coordinate.column == maxColumn - 1
    }

    private fun getNextCoordinates(
        coordinate: Coordinate,
        maze: Array<CharArray>,
        visited: Array<BooleanArray>,
        maxRow: Int,
        maxColumn: Int,
    ): List<Coordinate> {
        return (0..3).mapNotNull {
            val nextRow = coordinate.row + moveRow[it]
            val nextColumn = coordinate.column + moveColumn[it]

            if (
                nextRow in 0 until maxRow &&
                nextColumn in 0 until maxColumn &&
                !visited[nextRow][nextColumn] &&
                maze[nextRow][nextColumn] != WALL
            ) {
                Coordinate(nextRow, nextColumn, coordinate.movedCount + 1)
            } else {
                null
            }
        }
    }

    companion object {
        private val moveRow = intArrayOf(-1, 1, 0, 0)
        private val moveColumn = intArrayOf(0, 0, -1, 1)
        private const val WALL = '+'
    }
}

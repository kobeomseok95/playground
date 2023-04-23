package programmers.level2

import java.util.*

class Solution154540 {
    private val dy = arrayOf(-1, 1, 0, 0)
    private val dx = arrayOf(0, 0, -1, 1)
    private lateinit var visited: Array<BooleanArray>
    private lateinit var map: Array<String>

    data class Position(
        val y: Int,
        val x: Int,
    )

    fun solution(maps: Array<String>): List<Int> {
        map = maps
        val answer = mutableListOf<Int>()
        visited = Array(maps.size) { BooleanArray(maps[0].length) { false } }

        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                if (visited[i][j].not() && maps[i][j] != 'X') {
                    val sum = bfs(Position(y = i, x = j))
                    answer.add(sum)
                }
            }
        }
        return answer.takeIf { it.isNotEmpty() }?.sorted() ?: listOf(-1)
    }

    private fun bfs(position: Position): Int {
        val q = LinkedList<Position>()
        q.add(position)
        visited[position.y][position.x] = true
        var sum = 0
        while (q.isNotEmpty()) {
            val pos = q.poll()
            sum += map[pos.y][pos.x].digitToInt()
            for (i in 0 until 4) {
                val nextY = pos.y + dy[i]
                val nextX = pos.x + dx[i]

                if (
                    0 <= nextY && nextY < map.size &&
                    0 <= nextX && nextX < map[0].length &&
                    map[nextY][nextX] != 'X' &&
                    visited[nextY][nextX].not()
                ) {
                    q.add(Position(y = nextY, x = nextX))
                    visited[nextY][nextX] = true
                }
            }
        }
        return sum
    }
}

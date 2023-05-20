package programmers.level2

import java.lang.IllegalArgumentException
import java.util.LinkedList

class Solution159993 {
    /**
     * 1. 시작 지점 찾기
     * 2. 레버까지 최소 지점 찾기
     * 3. 출구까지 최쇠 지점 찾기
     */
    fun solution(maps: Array<String>): Int {
        var answer = -1
        val start = findStartPoint(maps)
        val lever = findPoint(maps, start, LEVER)
        val end = lever?.let { findPoint(maps, it, END) } ?: return -1
        return end.distance
    }

    private fun findStartPoint(maps: Array<String>): Point {
        for (y in maps.indices) {
            for (x in maps[y].indices) {
                if (maps[y][x] == 'S') {
                    return Point(y, x, 0)
                }
            }
        }
        throw IllegalArgumentException("시작 포인트가 존재하지 않습니다.")
    }

    private fun findPoint(maps: Array<String>, start: Point, end: Char): Point? {
        val visited = Array(maps.size) { BooleanArray(maps[0].length) { false } }
            .apply { this[start.y][start.x] = true }
        val q = LinkedList<Point>()
            .apply { add(start) }

        while (q.isNotEmpty()) {
            val current = q.poll()
            if (maps[current.y][current.x] == end) {
                return current
            }

            IntRange(0, 3).forEach {
                val nextY = current.y + dy[it]
                val nextX = current.x + dx[it]
                if (
                    isSatisfiedMapSize(
                        y = nextY,
                        x = nextX,
                        mapY = maps.size,
                        mapX = maps[0].length,
                    )
                ) {
                    if (maps[nextY][nextX] != WALL && !visited[nextY][nextX]) {
                        q.add(Point(nextY, nextX, current.distance + 1))
                        visited[nextY][nextX] = true
                    }
                }
            }
        }

        return null
    }

    companion object {
        private const val LEVER = 'L'
        private const val END = 'E'
        private const val WALL = 'X'
        private val dy = listOf(-1, 1, 0, 0)
        private val dx = listOf(0, 0, -1, 1)
        private fun isSatisfiedMapSize(
            y: Int,
            x: Int,
            mapY: Int,
            mapX: Int,
        ): Boolean = y in 0 until mapY && x in 0 until mapX
    }

    data class Point(
        val y: Int,
        val x: Int,
        val distance: Int,
    )
}

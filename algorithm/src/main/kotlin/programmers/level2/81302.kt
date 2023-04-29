package programmers.level2

import java.util.*

class Solution81302 {
    fun solution(places: Array<Array<String>>): List<Int> {
        return places.map { validateDistance(it) }.toList()
    }

    private fun validateDistance(place: Array<String>): Int {
        val startPositions = mutableListOf<Position>()
        for (i in place.indices) {
            for (j in 0 until place[i].length) {
                if (place[i][j] == 'P') {
                    startPositions.add(Position(y = i, x = j))
                }
            }
        }

        for (start in startPositions) {
            val q = LinkedList<Position>()
            val visited = Array(place.size) { BooleanArray(place[0].length) { false } }
            q.add(start)
            visited[start.y][start.x] = true

            while (q.isNotEmpty()) {
                val position = q.poll()
                for (i in 0 until 4) {
                    val nextY = position.y + dy[i]
                    val nextX = position.x + dx[i]

                    if (inRangePlaceSize(nextY, place, nextX) && !visited[nextY][nextX]) {
                        if (place[nextY][nextX] == 'O' && position.distanceCount < 2) {
                            q.add(
                                Position(
                                    y = nextY,
                                    x = nextX,
                                    distanceCount = position.distanceCount + 1
                                )
                            )
                            visited[nextY][nextX] = true
                        } else if (place[nextY][nextX] == 'X' || position.distanceCount >= 2) {
                            continue
                        } else {
                            return 0
                        }
                    }
                }
            }
        }

        return 1
    }

    private fun inRangePlaceSize(nextY: Int, place: Array<String>, nextX: Int) = 0 <= nextY &&
            nextY < place.size &&
            0 <= nextX &&
            nextX < place[0].length

    companion object {
        private val dy = intArrayOf(-1, 1, 0, 0)
        private val dx = intArrayOf(0, 0, -1, 1)

        data class Position(
            val y: Int,
            val x: Int,
            val distanceCount: Int = 0,
        )
    }
}

package boj.gold

import kotlin.math.abs

class `1027` {
    fun solution(n: Int, heights: List<Int>): Int {
        var max = 0
        heights.indices.forEach { i ->
            max = max.coerceAtLeast(getMaxCounts(i, n, heights))
        }
        return max
    }

    private fun getMaxCounts(centerIndex: Int, n: Int, heights: List<Int>): Int {
        var count = 0
        var tempInclination = 0.toDouble()

        for (i in centerIndex + 1 until n) {
            val inclination = getInclination(x1 = centerIndex, x2 = i, y1 = heights[centerIndex], y2 = heights[i])
            if (abs(i - centerIndex) == 1 || inclination > tempInclination) {
                count += 1
                tempInclination = inclination
            }
        }

        for (i in centerIndex - 1 downTo 0) {
            val inclination = getInclination(x1 = i, x2 = centerIndex, y1 = heights[i], y2 = heights[centerIndex])
            if (abs(i - centerIndex) == 1 || inclination < tempInclination) {
                count += 1
                tempInclination = inclination
            }
        }
        return count
    }

    private fun getInclination(x1: Int, x2: Int, y1: Int, y2: Int): Double {
        return (y2 - y1).toDouble() / abs(x2 - x1).toDouble()
    }
}

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    println(`1027`().solution(n, arr))
}

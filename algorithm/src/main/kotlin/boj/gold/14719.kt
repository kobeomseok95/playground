package boj.gold

class `14719` {
    fun solution(height: Int, width: Int, heights: List<Int>): Int {
        val leftMax = IntArray(width)
        var max = -1
        (0 until width).forEach { i ->
            leftMax[i] = max
            max = max.coerceAtLeast(heights[i])
        }

        val rightMax = IntArray(width)
        max = -1
        (width - 1 downTo 0).forEach { i ->
            rightMax[i] = max
            max = max.coerceAtLeast(heights[i])
        }

        var count = 0
        (0 until width).forEach { i ->
            val minOfMaxHeight = minOf(leftMax[i], rightMax[i])
            if (minOfMaxHeight > heights[i]) {
                count += minOfMaxHeight - heights[i]
            }
        }
        return count
    }
}

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toInt() }
    println(`14719`().solution(h, w, heights))
}

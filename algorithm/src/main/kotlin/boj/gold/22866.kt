package boj.gold

import java.util.Stack

class `22866` {
    fun solution(heights: List<Int>): List<List<Int>> {
        val near = IntArray(heights.size) { -100000 }
        val count = IntArray(heights.size) { 0 }

        val stack = Stack<Int>()
        (1 until heights.size).forEach { i ->
            while (stack.isNotEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop()
            }
            count[i] = stack.size
            if (count[i] > 0) {
                near[i] = stack.peek()
            }
            stack.push(i)
        }

        stack.clear()
        (heights.size - 1 downTo 1).forEach { i ->
            while (stack.isNotEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop()
            }
            val size = stack.size
            count[i] += size
            if (size > 0 && stack.peek() - i < i - near[i]) {
                near[i] = stack.peek()
            }
            stack.push(i)
        }

        return (1 until heights.size).map { i ->
            if (count[i] == 0) {
                listOf(0)
            } else {
                listOf(count[i], near[i])
            }
        }
    }
}

fun main() {
    val n = readln().toInt()
    val heights = listOf(0) + readln().split(" ").map { it.toInt() }
    val result = `22866`().solution(heights)
    result.forEach { println(it.joinToString(" ")) }
}

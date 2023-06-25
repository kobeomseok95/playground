package leetcode.medium

import java.util.Stack

class `2580` {
    fun countWays(ranges: Array<IntArray>): Int {
        return pow(
            exponent = ranges.sortedWith(compareBy({ it[0] }, { it[1] }))
                .merge()
                .size,
        )
    }

    private fun List<IntArray>.merge(): List<IntArray> {
        val stack = Stack<IntArray>()
        this.indices.forEach { i ->
            val merged = stack.lastOrNull()?.let { last ->
                if (last[1].isOverlap(this[i][0])) {
                    val popLast = stack.pop()
                    createMergeArray(popLast, this[i])
                } else {
                    this[i]
                }
            } ?: this[i]
            stack.push(merged)
        }
        return stack.toList()
    }

    private fun Int.isOverlap(other: Int): Boolean = this >= other

    private fun createMergeArray(base: IntArray, other: IntArray): IntArray {
        return intArrayOf(base[0], other[1].coerceAtLeast(base[1]))
    }

    private fun pow(exponent: Int): Int {
        var answer = 1
        (1..exponent).forEach { _ ->
            answer = (answer * 2) % MOD
        }
        return answer
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}

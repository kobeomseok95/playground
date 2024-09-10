package boj.silver

import java.util.LinkedList

class `1463` {
    fun solution(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }.apply {
            this[1] = 0
        }
        (2..n).forEach { i ->
            dp[i] = minOf(
                dp[i - 1] + 1,
                getOrMax(dp, i, 3),
                getOrMax(dp, i, 2),
            )
        }
        return dp[n]
    }

    private fun getOrMax(dp: IntArray, i: Int, divide: Int): Int {
        return if (i % divide == 0) {
            dp[i / divide] + 1
        } else {
            Int.MAX_VALUE
        }
    }
}

class `1463_2` {
    fun solution(n: Int): Int {
        val visit = BooleanArray(n + 1).apply { this[n] = true }
        val queue = LinkedList<Pair<Int, Int>>().apply { this.add(n to 0) }

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (current, dist) = queue.pop()
                if (current == 1) {
                    return dist
                }

                if (current % 3 == 0 && !visit[current / 3]) {
                    visit[current / 3] = true
                    queue.add(current / 3 to dist + 1)
                }
                if (current % 2 == 0 && !visit[current / 2]) {
                    visit[current / 2] = true
                    queue.add(current / 2 to dist + 1)
                }
                if (!visit[current - 1]) {
                    visit[current - 1] = true
                    queue.add(current - 1 to dist + 1)
                }
            }
        }
        return 1
    }
}

class `1463_3` {
    fun solution(n: Int): Int {
        if (n < 2) {
            return 0
        }
        return minOf(
            a = solution(n / 2) + (n % 2),
            b = solution(n / 3) + (n % 3),
        ) + 1
    }
}

fun main() {
    val n = readln().toInt()
    `1463_3`().solution(n).apply(::println)
}

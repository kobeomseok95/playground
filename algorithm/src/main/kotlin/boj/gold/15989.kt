package boj.gold

import java.io.BufferedReader

class `15989` {
    fun solve(n: Int): Int {
        val dp = Array(n + 1) { IntArray(4) }.apply {
            this[1][1] = 1
            this[1][2] = 0
            this[1][3] = 0
            if (n >= 2) {
                this[2][1] = 1
                this[2][2] = 1
                this[2][3] = 0
            }
            if (n >= 3) {
                this[3][1] = 1
                this[3][2] = 1
                this[3][3] = 1
            }
        }
        (4..n).forEach { i ->
            dp[i][1] = dp[i - 1][1]
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
        }
        return dp[n].sum()
    }
}

fun main() {
    val reader = BufferedReader(System.`in`.reader())
    val t = reader.readLine().toInt()
    val solution = `15989`()
    val answers = mutableListOf<Int>()
    (0 until t).forEach {
        val n = reader.readLine().toInt()
        answers.add(solution.solve(n))
    }
    println(answers.joinToString("\n"))
}

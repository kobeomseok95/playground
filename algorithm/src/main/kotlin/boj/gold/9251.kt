package boj.gold

class `9251` {
    fun solution(a: String, b: String): Int {
        val dp = Array(b.length + 1) { IntArray(a.length + 1) }
        (1..b.length).forEach { i ->
            (1..a.length).forEach { j ->
                if (a[j - 1] == b[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[b.length][a.length]
    }
}

fun main() {
    val a = readln()
    val b = readln()
    println(`9251`().solution(a, b))
}

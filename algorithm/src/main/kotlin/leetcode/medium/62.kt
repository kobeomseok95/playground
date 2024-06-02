package leetcode.medium

class `62` {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) { 1 } }
        (1 until m).forEach { i ->
            (1 until n).forEach { j ->
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}

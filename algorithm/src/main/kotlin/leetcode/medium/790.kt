package leetcode.medium

class `790` {
    fun numTilings(n: Int): Int {
        if (n <= 2) {
            return n
        }
        val dp = Array(n + 1) { LongArray(3) }
        dp[1][0] = 1
        dp[2][0] = 2
        dp[2][1] = 1
        dp[2][2] = 1

        (3..n).forEach { i ->
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % MODULO
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % MODULO
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][2]) % MODULO
        }

        return dp[n][0].toInt()
    }

    companion object {
        private const val MODULO = 1_000_000_000 + 7
    }
}

package leetcode.medium

class `714` {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val n = prices.size
        val dp = Array(n) { IntArray(2) { -1 } }
        dp[0][SELL] = 0
        dp[0][BUY] = -prices[0] - fee

        (1 until n).forEach { i ->
            dp[i][SELL] = maxOf(
                a = dp[i - 1][BUY] + prices[i],
                b = dp[i - 1][SELL],
            )
            dp[i][BUY] = maxOf(
                a = dp[i - 1][BUY],
                b = dp[i - 1][SELL] - prices[i] - fee,
            )
        }

        return dp[n - 1][SELL]
    }

    companion object {
        private const val SELL = 0
        private const val BUY = 1
    }
}

fun main() {
    `714`().maxProfit(
        prices = intArrayOf(1,3,2,8,4,9),
        fee = 2,
    ).apply(::println)
    `714`().maxProfit(
        prices = intArrayOf(1,3,7,5,10,3),
        fee = 3,
    ).apply(::println)
}

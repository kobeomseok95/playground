package leetcode.medium

class `322` {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val sum = IntArray(amount + 1) { Int.MAX_VALUE }.apply { this[0] = 0 }

        for (i in coins.indices) {
            for (j in (coins[i]..amount)) {
                val result = sum[j - coins[i]]
                sum[j] = if (result == Int.MAX_VALUE) {
                    sum[j]
                } else {
                    sum[j].coerceAtMost(result + 1)
                }
            }
        }

        return sum[amount].takeIf { it != Int.MAX_VALUE } ?: -1
    }
}

class `322_2` {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val max = amount + 1
        val dp = IntArray(amount + 1) { max }.apply { this[0] = 0 }

        for (amountValue in (1..amount)) {
            for (coin in coins) {
                if (amountValue - coin >= 0) {
                    dp[amountValue] = dp[amountValue].coerceAtMost(1 + (dp[amountValue - coin]))
                }
            }
        }
        return dp[amount].takeIf { it != max } ?: -1
    }
}

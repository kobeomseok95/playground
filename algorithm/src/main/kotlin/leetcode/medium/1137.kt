package leetcode.medium

class `1137` {
    fun tribonacci(n: Int): Int {
        val dp = IntArray(n + 1) { 0 }

        (0..n).forEach {
            when (it) {
                0 -> dp[0] = 0
                1 -> dp[1] = 1
                2 -> dp[2] = 1
                else -> dp[it] = dp[it - 1] + dp[it - 2] + dp[it - 3]
            }
        }

        return dp.last()
    }
}

fun main() {
    `1137`().tribonacci(0).apply(::println)
    `1137`().tribonacci(4).apply(::println)
    `1137`().tribonacci(25).apply(::println)
}

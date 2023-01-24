package programmers.level2

class Solution12945 {
    fun solution(n: Int): Int {
        val dp = Array(100_001) { 0 }
        dp[0] = 0
        dp[1] = 1
        for (i in 2 .. n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_234_567
        }
        return dp[n]
    }
}

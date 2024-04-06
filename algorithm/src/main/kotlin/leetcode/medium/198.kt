package leetcode.medium

class `198` {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 0 }
        nums.indices.forEach {
            when (it) {
                0 -> dp[it] = nums[it]
                1 -> dp[it] = maxOf(nums[it - 1], nums[it])
                else -> dp[it] = maxOf(dp[it - 2] + nums[it], dp[it - 1])
            }
        }
        return dp.last()
    }
}

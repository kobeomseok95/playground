package leetcode.medium

class `1027` {
    fun longestArithSeqLength(nums: IntArray): Int {
        val memo = Array<HashMap<Int, Int>>(nums.size) { hashMapOf() }
        var max = 0

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                val diff = nums[i] - nums[j]
                memo[i][diff] = (memo[j][diff] ?: 1) + 1
                max = max.coerceAtLeast(memo[i][diff]!!)
            }
        }

        return max
    }
}

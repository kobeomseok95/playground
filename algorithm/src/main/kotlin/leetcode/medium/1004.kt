package leetcode.medium

class `1004` {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0
        var zeroCount = 0
        while (right < nums.size) {
            if (nums[right] == 0) {
                zeroCount += 1
            }
            right += 1

            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount -= 1
                }
                left += 1
            }
        }

        return right - left
    }
}

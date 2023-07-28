package leetcode.medium

class `34` {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var left = -1
        var right = -1

        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val mid = (start + end) / 2
            val value = nums[mid]
            if (target < value) {
                end = mid - 1
            } else if (value == target) {
                (mid downTo 0).forEach { i ->
                    if (nums[i] == target) {
                        left = i
                    }
                }
                (mid until nums.size).forEach { i ->
                    if (nums[i] == target) {
                        right = i
                    }
                }
                return intArrayOf(left, right)
            } else {
                start = mid + 1
            }
        }

        return intArrayOf(left, right)
    }
}

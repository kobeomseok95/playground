package leetcode.medium

class `162` {
    fun findPeakElement(nums: IntArray): Int {
        return dfs(nums)
    }

    private fun dfs(
        nums: IntArray,
        left: Int = 0,
        right: Int = nums.size - 1,
    ): Int {
        if (left == right) {
            return 0
        }

        if (left + 1 == right) {
            return if (nums[left] > nums[right]) left else right
        }

        val mid = (left + right) / 2
        if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid
        } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            return dfs(nums, mid, right)
        } else {
            return dfs(nums, left, mid)
        }
    }
}

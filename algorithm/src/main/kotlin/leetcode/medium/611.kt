package leetcode.medium

class `611` {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var left = 0
        var right = 0
        var triangleAvailableCount = 0

        while (left != nums.size - 1 || right != nums.size - 1) {
            for (i in left + 1 until right) {
                if (nums[right] < nums[left] + nums[i]) {
                    triangleAvailableCount += 1
                }
            }

            if (right < nums.size - 1) {
                right += 1
            } else {
                left += 1
                right = left
            }
        }
        return triangleAvailableCount
    }
}

package leetcode.medium


class `1679` {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var left = 0
        var right = nums.size - 1
        val sortedNums = nums.sorted().toMutableList()
        var count = 0
        while (left < right) {
            val sum = sortedNums[left] + sortedNums[right]
            if (sum < k) {
                left += 1
            } else if (sum > k) {
                right -= 1
            } else {
                count += 1
                left += 1
                right -= 1
            }
        }
        return count
    }
}

package leetcode.medium

import kotlin.math.abs

class `16` {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var answer = 0
        var distance = Int.MAX_VALUE
        nums.sort()
        (0 until nums.size - 2).forEach { i ->
            (i + 1 until nums.size).forEach { j ->
                var k = j + 1
                while (k < nums.size) {
                    val threeSum = nums[i] + nums[j] + nums[k]
                    val abs = abs(target - threeSum)
                    if (abs < distance) {
                        answer = threeSum
                        distance = abs
                    }
                    k += 1
                }
            }
        }

        return answer
    }
}

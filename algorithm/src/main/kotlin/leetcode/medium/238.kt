package leetcode.medium

class `238` {
    fun productExceptSelf(nums: IntArray): IntArray {
        val before = IntArray(nums.size) { 1 }
        val after = IntArray(nums.size) { 1 }
        (1..nums.lastIndex).forEach { i ->
            before[i] = nums[i - 1] * before[i - 1]
        }
        (nums.lastIndex - 1 downTo 0).forEach { i ->
            after[i] = nums[i + 1] * after[i + 1]
        }

        val result = IntArray(nums.size) { 0 }
        (0 until nums.size).forEach { i ->
            result[i] = before[i] * after[i]
        }
        return result
    }
}

class `238_2` {
    fun productExceptSelf(nums: IntArray): IntArray {
        val end = nums.lastIndex
        val result = IntArray(nums.size) { 1 }
        var left = 1
        var right = 1

        nums.indices.forEach {
            result[it] *= left
            result[end - it] *= right

            left *= nums[it]
            right *= nums[end - it]
        }
        return result
    }
}

fun main() {
    `238_2`().productExceptSelf(
        nums = intArrayOf(1, 2, 3, 4),
    ).onEach { println(it) }

    `238_2`().productExceptSelf(
        nums = intArrayOf(-1, 1, 0, -3, 3),
    ).onEach { println(it) }
}

package leetcode.medium

class `11` {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val area = (right - left) * height[left].coerceAtMost(height[right])
            maxArea = maxArea.coerceAtLeast(area)
            if (height[left] < height[right]) {
                left += 1
            } else {
                right -= 1
            }
        }
        return maxArea
    }
}

fun main() {
    `11`().apply {
        maxArea(
            height = intArrayOf(1,8,6,2,5,4,8,3,7),
        ).apply(::println)
        maxArea(
            height = intArrayOf(1,1),
        ).apply(::println)
        maxArea(
            height = intArrayOf(1,2,1),
        ).apply(::println)
    }
}

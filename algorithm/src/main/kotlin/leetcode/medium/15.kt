package leetcode.medium

class `15` {
    fun threeSumTwoPointers(nums: IntArray): List<List<Int>> {
        nums.sort()
        val triplets = mutableSetOf<List<Int>>()

        nums.indices.forEach { i ->
            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[left] + nums[i] + nums[right]

                when {
                    sum > 0 -> right -= 1
                    sum < 0 -> left += 1
                    else -> {
                        triplets.add(listOf(nums[left], nums[i], nums[right]))
                        left += 1
                    }
                }
            }
        }

        return triplets.toList()
    }

    fun threeSumBinarySearch(nums: IntArray): List<List<Int>> {
        val triplets = mutableSetOf<List<Int>>()
        nums.sort()
        nums.indices.forEach { i ->
            val target = 0 - nums[i]
            var left = 0
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[left] + nums[right]

                when {
                    sum > target -> right -= 1
                    sum < target -> left += 1
                    else -> {
                        if (i != left && i != right) {
                            triplets.add(listOf(nums[left], nums[right], nums[i]).sorted())
                        }
                        left += 1
                    }
                }
            }
        }
        return triplets.toList()
    }
}
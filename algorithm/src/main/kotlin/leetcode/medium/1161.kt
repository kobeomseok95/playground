package leetcode.medium

import java.util.LinkedList

class `1161` {
    fun maxLevelSum(root: TreeNode1161?): Int {
        var maxSum = Int.MIN_VALUE
        var currentLevel = 0
        var maxLevel = 0
        val queue = LinkedList<TreeNode1161?>().apply {
            add(root)
            currentLevel = 1
        }

        while (queue.isNotEmpty()) {
            val nodeByLevel = mutableListOf<TreeNode1161>()
            while (queue.isNotEmpty()) {
                queue.pop()?.let { nodeByLevel.add(it) }
            }

            val sum = nodeByLevel.sumOf { it.`val` }
            if (maxSum < sum) {
                maxSum = sum
                maxLevel = currentLevel
            }

            nodeByLevel.forEach {
                it.left?.let { queue.add(it) }
                it.right?.let { queue.add(it) }
            }

            currentLevel += 1
        }
        return maxLevel
    }
}

data class TreeNode1161(
    var `val`: Int,
) {
    var left: TreeNode1161? = null
    var right: TreeNode1161? = null
}

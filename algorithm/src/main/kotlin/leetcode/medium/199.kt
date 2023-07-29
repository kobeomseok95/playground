package leetcode.medium

import java.util.LinkedList

class `199` {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val answer = mutableListOf<List<Int>>()
        val q = LinkedList<TreeNode>().apply { add(root) }
        while (q.isNotEmpty()) {
            val polledNumbers = mutableListOf<Int>()
            (0 until q.size).forEach {
                val node = q.pop()
                node.left?.run(q::add)
                node.right?.run(q::add)
                polledNumbers.add(node.`val`)
            }
            answer.add(polledNumbers.toList())
        }
        return answer.map { it.last() }
    }
}

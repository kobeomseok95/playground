package leetcode.medium

class `1448` {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun goodNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return dfs(
            node = root,
            maxValue = root.`val`,
        )
    }

    private fun dfs(
        node: TreeNode,
        maxValue: Int,
    ): Int {
        val count = if (maxValue <= node.`val`) 1 else 0

        val left = node.left?.let { left ->
            dfs(
                node = left,
                maxValue = maxValue.coerceAtLeast(left.`val`),
            )
        } ?: 0

        val right = node.right?.let { right ->
            dfs(
                node = right,
                maxValue = maxValue.coerceAtLeast(right.`val`),
            )
        } ?: 0

        return count + left + right
    }
}

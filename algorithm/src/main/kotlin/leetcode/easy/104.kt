package leetcode.easy

class `104` {
    fun maxDepth(root: TreeNode?): Int {
        return dfs(root, root?.let{ 1 } ?: 0)
    }

    private fun dfs(node: TreeNode?, depth: Int): Int {
        if (node == null) return depth

        return maxOf(
            dfs(node.left, node.left?.let { depth + 1 } ?: depth),
            dfs(node.right, node.right?.let { depth + 1 } ?: depth),
        )
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

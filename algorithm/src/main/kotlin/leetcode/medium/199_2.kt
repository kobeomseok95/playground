package leetcode.medium

class `199_2` {
    private val nodesAtLevel = mutableMapOf<Int, List<Int>>()

    fun rightSideView(root: TreeNode?): List<Int> {
        dfs(root, 0)
        return nodesAtLevel.values.map { it.last() }
    }

    private fun dfs(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }

        nodesAtLevel[level] = (nodesAtLevel[level] ?: emptyList()) + listOf(root.`val`)
        dfs(root.left, level + 1)
        dfs(root.right, level + 1)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

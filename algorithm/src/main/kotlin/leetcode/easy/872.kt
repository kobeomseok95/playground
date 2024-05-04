package leetcode.easy

class `872` {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return getLeafSequence(root1) == getLeafSequence(root2)
    }

    private fun getLeafSequence(
        node: TreeNode?,
        leafSequence: List<Int> = listOf(),
    ): List<Int> {
        if (node == null) {
            return leafSequence
        }
        if (node.left == null && node.right == null) {
            return leafSequence + listOf(node.`val`)
        }

        return getLeafSequence(
            node = node.left,
            leafSequence = leafSequence,
        ) + getLeafSequence(
            node = node.right,
            leafSequence = leafSequence,
        )
    }
}

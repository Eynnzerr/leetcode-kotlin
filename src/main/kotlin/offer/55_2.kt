package offer

import TreeNode
import kotlin.math.abs
import kotlin.math.max

class Solution55_2 {
    fun isBalanced(root: TreeNode?): Boolean = if (root == null) true else abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)

    private fun maxDepth(root: TreeNode?): Int = if (root == null) 0 else 1 + max(maxDepth(root.left), maxDepth(root.right))
}
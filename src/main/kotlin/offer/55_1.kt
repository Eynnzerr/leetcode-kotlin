package offer

import TreeNode
import kotlin.math.max

class Solution55_1 {
    fun maxDepth(root: TreeNode?): Int = if (root == null) 0 else 1 + max(maxDepth(root.left), maxDepth(root.right))
}
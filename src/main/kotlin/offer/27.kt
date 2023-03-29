package offer

import TreeNode

class Solution27 {
    fun mirrorTree(root: TreeNode?): TreeNode? = when {
        root == null -> null
        root.left == null && root.right == null -> root
        else -> root.apply {
            val temp = left
            left = mirrorTree(right)
            right = mirrorTree(temp)
        }
    }
}
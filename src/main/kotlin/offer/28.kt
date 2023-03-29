package offer

import TreeNode

class Solution28 {
    fun isSymmetric(root: TreeNode?): Boolean = isSymmetric(root, root)

    private fun isSymmetric(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null && root2 == null) return true
        if (root1 == null || root2 == null) return false
        if (root1.`val` != root2.`val`) return false
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left)
    }
}
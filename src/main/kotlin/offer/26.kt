package offer

import TreeNode

class Solution26 {
    // 遍历寻找相同值节点
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        var result = false
        if (A != null && B != null) {
            if (A.`val` == B.`val`) result = containsSubTree(A, B)
            if (!result) result = isSubStructure(A.left, B)
            if (!result) result = isSubStructure(A.right, B)
        }
        return result
    }

    // 判断子结构
    private fun containsSubTree(A: TreeNode?, B: TreeNode?): Boolean {
        // 应该先判断B是否为空。如当A B均为值相同的单节点时，B是A的子结构，但此时A B都没有子树。
        B ?: return true
        A ?: return false

        if (A.`val` != B.`val`) return false

        return containsSubTree(A.left, B.left) && containsSubTree(A.right, B.right)
    }
}
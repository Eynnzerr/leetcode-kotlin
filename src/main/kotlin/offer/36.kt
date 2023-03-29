package offer

import TreeNode

class Solution36 {
    fun treeToDoublyList(root: TreeNode?): TreeNode? {
        root ?: return null
        treeToDoublyList(root.left)
        treeToDoublyList(root.right)

        // 找到左子树最右节点 将其与根双向连接
        root.left?.let {
            var mostRight = it
            while (mostRight.right != null) {
                mostRight = mostRight.right!!
            }
            mostRight.right = root
            root.left = mostRight
        }

        // 找到右子树最左节点 将其与根双向连接
        root.right?.let {
            var mostLeft = it
            while (mostLeft.left != null) {
                mostLeft = mostLeft.left!!
            }
            mostLeft.left = root
            root.right = mostLeft
        }

        // 返回最小节点
        var smallest = root
        while (root.left != null) smallest = root.left
        return smallest
    }
}
package offer

import TreeNode
import java.util.LinkedList

class Solution32 {
    fun levelOrder(root: TreeNode?): IntArray {
        root ?: return IntArray(0)
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        val list = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            list.add(node.`val`)
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        return list.toIntArray()
    }
}
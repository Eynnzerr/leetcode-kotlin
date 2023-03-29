package offer

import TreeNode
import java.util.*

class Solution32_2 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        root ?: return res
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        while (queue.isNotEmpty()) {
            val layerCount = queue.size
            val list = mutableListOf<Int>()
            repeat(layerCount) {
                val node = queue.poll()
                list.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            res.add(list)
        }
        return res
    }
}
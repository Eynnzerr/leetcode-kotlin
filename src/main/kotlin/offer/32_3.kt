package offer

import TreeNode
import java.util.*

class Solution32_3 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        // 这次想偷懒的话其实很简单，在32-2答案的基础上偶数层列表倒序即可，具体做法是列表换成双端队列，偶数时反着插。
        val res = mutableListOf<List<Int>>()
        root ?: return res
        val queue = LinkedList<TreeNode>().apply { offer(root) }
        var isReversed = true
        while (queue.isNotEmpty()) {
            val layerCount = queue.size
            val list = LinkedList<Int>()
            repeat(layerCount) {
                val node = queue.poll()
                if (isReversed)
                    list.add(node.`val`)
                else
                    list.addFirst(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            res.add(list)
            isReversed = !isReversed
        }
        return res
    }
}
package offer

import TreeNode
import java.util.LinkedList

class Codec {
    fun serialize(root: TreeNode?) = bfsSerialize(root)

    fun deserialize(data: String) = bfsDeserialize(data)

    private fun bfsSerialize(root: TreeNode?) : String {
        root ?: return ""
        val sb = StringBuilder()
        val queue = LinkedList<TreeNode>().apply { add(root) }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node != null) {
                queue.offer(node.left)
                queue.offer(node.right)
                sb.append(node.`val`)
            } else {
                sb.append("null")
            }
            sb.append(",")
        }
        return sb.toString()
    }

    private fun bfsDeserialize(data: String): TreeNode? {
        if (data == "") return null
        val vals = data.split(",")
        var childIndex = 1
        val root = TreeNode(vals[0].toInt())
        val queue = LinkedList<TreeNode>().apply { add(root) }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (vals[childIndex] != "null") {
                val left = TreeNode(vals[childIndex].toInt());
                node.left = left;
                queue.offer(left);
            }
            childIndex ++;

            if (vals[childIndex] != "null") {
                val right = TreeNode(vals[childIndex].toInt());
                node.right = right;
                queue.offer(right);
            }
            childIndex ++;
        }
        return root
    }
}
package offer

import TreeNode

class Solution34 {
    fun pathSum(root: TreeNode?, target: Int): List<List<Int>> {
        // 一眼前序遍历+回溯
        // 使用一个变量保存到当前位置为止的路径和，另一个列表变量保存从根到当前位置的路径
        // 当前为叶子节点时，判断路径和是否为目标值，是则将当前列表保存到list<list>中
        val paths = mutableListOf<List<Int>>()
        backtrack(root, target, mutableListOf(), paths)
        return paths
    }

    private fun backtrack(root: TreeNode?, target: Int, path: MutableList<Int>, paths: MutableList<List<Int>>) {
        root ?: return
        path.add(root.`val`)
        if (root.left == null && root.right == null && path.sum()  == target) {
            paths.add(ArrayList(path))
            // 这里别多return，不然当前点值删不掉
        }
        backtrack(root.left, target, path, paths)
        backtrack(root.right, target, path, paths)
        // 这里别用path.remove(root.`val`)，当多个值相同时会删除第一个，导致顺序不对了
        path.removeLast()
        // path.removeAt(path.lastIndex) 力扣不识别removeLast()，要调用这个
    }
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(-2).apply {
            left = TreeNode(1).apply {
                left = TreeNode(1)
            }
            right = TreeNode(3)
        }
        right = TreeNode(-3).apply {
            left = TreeNode(-2)
        }
    }
    print(Solution34().pathSum(root, 2))


}
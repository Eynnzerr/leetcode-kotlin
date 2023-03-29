package offer

class Solution33 {
    fun verifyPostorder(postorder: IntArray): Boolean {
        // BST 左子树小于根小于等于右子树，故可从数组读出右子树节点
        // 判断是否满足全部右子树节点大于根
        // 递归判断左右子树
        if (postorder.size <= 1) return true
        val root = postorder.last()
        var rightStartIdx = 0
        while (postorder[rightStartIdx] < root) rightStartIdx ++
        for (i in rightStartIdx..postorder.lastIndex) {
            if (postorder[i] < root) return false
        }
        return verifyPostorder(postorder.sliceArray(0 until rightStartIdx)) && verifyPostorder(postorder.sliceArray(rightStartIdx until postorder.lastIndex))
    }
}

fun main() {
    val solution = Solution33()
    print(solution.verifyPostorder(intArrayOf(1,3,2,6,5)))
}
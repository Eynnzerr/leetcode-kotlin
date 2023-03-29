package offer

import java.util.LinkedList

class Solution31 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        // 核心思路：构造辅助栈
        val stack = LinkedList<Int>()
        var pushedCount = 0
        for (poppedNum in popped) {
            if (stack.isEmpty() || stack.peek() != poppedNum) {
                // 若当前待弹出数字不在栈顶，则将pushed数组中一直压人辅助栈，直到当前待弹出数字压在栈顶
                // 若当前可用数字已全部入栈，则说明压栈弹栈序列无法对应
                if (pushedCount == pushed.size) return false

                while (stack.peek() != poppedNum && pushedCount <= pushed.size) {
                    stack.push(pushed[pushedCount++])
                }
                stack.pop()
            } else {
                // 在栈顶，直接弹出
                stack.pop()
            }
        }
        return true
    }

    fun validateStackSequences2(pushed: IntArray, popped: IntArray): Boolean {
        // 力扣题解大佬的做法，与上面做法不同之处在于让pushed入栈
        val stack = LinkedList<Int>()
        var i = 0
        pushed.forEach {
            stack.push(it)
            while (stack.isNotEmpty() && stack.peek() == popped[i]) {
                stack.pop()
                i ++
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val solution = Solution31()
    print(solution.validateStackSequences2(intArrayOf(1,2,3,4,5), intArrayOf(4,5,3,2,1)))
}
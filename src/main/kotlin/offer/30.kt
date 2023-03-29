package offer

import java.util.LinkedList
import kotlin.math.min

class MinStack() {

    // 显而易见的思路是使用一个成员变量保存栈中的最小元素。但设想栈的工作状态后，可发现当该最小元素出栈后，次小元素变为最小元素，此时成员变量值错误
    // 故一个变量是不够的，需要能够始终保持次小值，即每次有元素入栈前，栈内的最小元素
    // 故可设置一个辅助栈来与该栈同步，保存每次入栈时栈内的最小元素
    private val minNums = LinkedList<Int>()
    private val stack = LinkedList<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (minNums.isEmpty()) minNums.push(x)
        else minNums.push(min(minNums.peek(), x))
    }

    fun pop() {
        stack.pop()
        minNums.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun min(): Int {
        return minNums.peek()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.min()
 */
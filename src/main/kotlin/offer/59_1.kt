package offer

import java.util.*

class Solution59_1 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        // 时间复杂度O(nk) n轮外循环遍历数组，k轮内循环优先队列出队 超时！
        // 思路：维护一个长度为k的优先队列，并将初始窗口入队。
        // 每向后滑动一步，检查出窗的元素是否为最大值，如果是则将根出队，否则查找该元素并将其出队。接着，入队新元素，并向答案添加根。
        val res = mutableListOf<Int>()
        val queue = PriorityQueue<Int>() { x, y -> y - x }.apply {
            addAll(nums.slice(0 until k))
            res.add(peek())
        }
        for (i in k..nums.lastIndex) {
            val out = nums[i - k]
            queue.remove(out)
            queue.add(nums[i])
            res.add(queue.peek())
        }
        return res.toIntArray()
    }

    fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
        // 如何减小时间复杂度？O(n)是肯定需要的，那么是否可以避免O(k)出队？需要控制队列的大小
        // 使用单调递减队列，则可以在保证队列单调下降的同时保证必要时出队，控制队列长度
        val res = IntArray(nums.size - k + 1)
        val queue: Deque<Int> = LinkedList()
        nums.forEachIndexed { index, num ->
            // index+1-k指向当前滑动窗口第一个数字，index-k指向当前出队元素
            // 当前待出队元素为最大值，则直接最大值出队即可继续维持单调递减
            if (index >= k && nums[index-k] == queue.peek()) queue.poll()
            //queue.removeIf { it < num } // 不能用这个删除。removeIf()是从头开始删，会调用迭代器删除 导致超时!
            while (queue.isNotEmpty() && queue.peekLast() < num) {
                queue.removeLast()
            }
            queue.offer(num)
            if (index >= k - 1) res[index - k + 1] = queue.peek()
        }
        return res
    }
}

fun main() {
    val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
    Solution59_1().maxSlidingWindow2(nums, 3).forEach { println(it) }
}
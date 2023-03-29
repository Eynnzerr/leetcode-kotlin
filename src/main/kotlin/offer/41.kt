package offer

import java.util.PriorityQueue

class MedianFinder() {

    // 2个堆：可以理解为把一个堆从中间掰开，从而实现找中位数时时间复杂度O(1) 以小空间换大时间
    private val head = PriorityQueue<Int> { x, y -> y - x } // 大根堆 存储比中位数小或相等的数
    private val tail = PriorityQueue<Int>() // 小根 存储比中位数大的数
    private var count = 0

    // 中位数->排序->总数又未知->优先队列
    // 2个堆轮流插入数据，并且每次插入新数据后都向另一个堆插入自己堆顶的数，以循序找出中位数
    fun addNum(num: Int) {
        if (count % 2 != 0) {
            head.add(num)
            tail.add(head.poll())
        } else {
            tail.add(num)
            head.add(tail.poll())
        }
        count ++
    }

    // 插入了奇数个时，中位数就是大根堆顶；插入了偶数个时，中位数就是大小根堆顶平均值
    fun findMedian() = if (count % 2 != 0) head.peek().toDouble() else (head.peek() + tail.peek()) / 2.toDouble()

}

fun main() {
    // test
    with(MedianFinder()) {
        arrayOf(1, 3, 2, 5, 4).forEach {
            addNum(it)
        }
        println(findMedian())
        addNum(4)
        println(findMedian())
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
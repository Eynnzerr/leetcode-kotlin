package offer

import java.util.PriorityQueue

class Solution40 {
    // 方法1. 简单排序
    fun getLeastNumbers1(arr: IntArray, k: Int) = arr.sorted().slice(0 until  k).toIntArray()

    // 方法2. 优先队列（大根堆） 维护一个k大小的大根堆
    fun getLeastNumbers2(arr: IntArray, k: Int): IntArray {
        // k <= arr.size
        if (k <= 0) return intArrayOf()
        val heap = PriorityQueue(Comparator<Int> { x, y -> y - x }).apply {
            addAll(arr.slice(0 until k))
        }
        for (i in k until arr.size) {
            if (arr[i] <= heap.peek()) {
                heap.poll()
                heap.offer(arr[i])
            }
        }
        return heap.toIntArray()
    }

    // 方法3. pivot
    fun getLeastNumbers3(arr: IntArray, k: Int) = if (k <= 0) intArrayOf()
        else if(k >= arr.size) arr
        else pivot(arr, k, 0, arr.size - 1)

    private fun pivot(arr: IntArray, k: Int, left: Int, right: Int): IntArray {
        var i = left
        var j = right

        while (i < j) {
            // 先递减j 再递减i 否则出问题。例：[0,1,2,1]
            while (i < j && arr[j] >= arr[left]) j --
            while (i < j && arr[i] <= arr[left]) i ++
            arr.swap(i, j)
        }
        arr.swap(left, i)
        // 经上步骤后，arr中前i个为最小的i+1个数
        return if (i > k) pivot(arr, k, left, i - 1)
            else if (i < k) pivot(arr, k, i + 1, right)
            else arr.sliceArray(0 until k)
    }

    private fun IntArray.swap(first: Int, second: Int) {
        val temp = this[first]
        this[first] = this[second]
        this[second] = temp
    }
}
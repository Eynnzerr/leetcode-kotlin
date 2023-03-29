package offer

class Solution57_2 {
    fun findContinuousSequence(target: Int): Array<IntArray> {
        // 一眼滑动窗口  但因为序列是连续正整数，求和有固定公式（d=1的等差数列），故可简化为双指针
        val res = mutableListOf<IntArray>()
        var left = 1
        var right = 2
        while (left < right) {
            val windowSum = (right * (right + 1) - left * (left + 1)) / 2 + left
            if (windowSum == target) {
                res.add((left..right).toList().toIntArray())
                left ++
            } else if (windowSum < target) {
                // 区间和小于目标值，还能继续扩充
                right ++
            } else {
                // 从小于到大于没有结束，说明以当前left为起点的区间没有和等于目标值的，故移动left到下一起点
                // 此时无需左移right，因为当left..right不满足时，(left+1)..x, x < right必定也不满足，可由假设法反推证明
                left ++
            }
        }
        return res.toTypedArray()
    }
}

fun main() {
    println(Solution57_2().findContinuousSequence(9))
}
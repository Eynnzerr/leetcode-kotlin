package offer

class Solution66 {
    // 构建乘积数组
    fun constructArr(a: IntArray): IntArray {
        // 没想出O(n)咋做，直接抄了K神题解
        // 要做出这题的关键在于画图。如果能画出A和B结果对应的表格，就能很容易找到规律。
        // 2轮迭代求出下三角和上三角，乘给结果数组即可
        if (a.isEmpty()) return IntArray(0)
        val b = IntArray(a.size).apply { this[0] = 1 }
        // 乘以下三角
        for (i in 1..b.lastIndex) {
            b[i] = b[i-1] * a[i-1]
        }
        // 乘以上三角
        var cum = 1
        for (i in b.lastIndex-1 downTo 0) {
            b[i] *= cum
            cum *= a[i+1]
        }
        return b
    }
}
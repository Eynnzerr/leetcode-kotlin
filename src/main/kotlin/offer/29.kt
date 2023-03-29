package offer

class Solution29 {
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        val res = mutableListOf<Int>()
        if (matrix.isEmpty() || matrix[0].isEmpty()) return IntArray(0)
        var top = 0
        var left = 0
        var bottom = matrix.size - 1
        var right = matrix[0].size - 1
        while (top <= bottom && left <= right) {
            // 上边从左向右遍历，上边遍历完后下缩
            for (i in left..right) {
                res.add(matrix[top][i])
            }
            top ++
            // 右边从上向下遍历，右边遍历完后左缩
            for (i in top..bottom) {
                res.add(matrix[i][right])
            }
            right --
            // 下边从右向左遍历，下边遍历完后上缩
            for (i in right downTo left) {
                res.add(matrix[bottom][i])
            }
            bottom --
            // 左边从下向上遍历，左边遍历完后右缩
            for (i in bottom downTo top) {
                res.add(matrix[i][left])
            }
            left ++
        }
        return res.toIntArray()
    }
}
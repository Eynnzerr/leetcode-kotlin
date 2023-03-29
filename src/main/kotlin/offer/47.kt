package offer

import kotlin.math.max

class Solution47 {
    fun maxValue(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val dp = Array(grid.size) { i -> IntArray(grid[0].size) { j -> grid[i][j] } }
        for (i in dp.indices) {
            for (j in dp[0].indices) {
                val left = if (i != 0) dp[i-1][j] else 0
                val up = if (j != 0) dp[i][j-1] else 0
                dp[i][j] += max(left, up)
            }
        }
        return dp[dp.size-1][dp[0].size-1]
    }
}
package offer

class Solution49 {
    fun nthUglyNumber(n: Int): Int {
        // 基本思路：动态规划
        // dp公式：dp[next] = min(2*dp[a],3*dp[b],5*dp[c])
        if (n == 1) return 1
        var a = 0
        var b = 0
        var c = 0
        val dp = IntArray(n).apply { this[0] = 1 }
        for (i in 1 until dp.size) {
            dp[i] = arrayOf(dp[a] * 2, dp[b] * 3, dp[c] * 5).min() // 力扣kt编译器有毛病 需要加!!
            if (dp[a] * 2 == dp[i]) a ++
            if (dp[b] * 3 == dp[i]) b ++
            if (dp[c] * 5 == dp[i]) c ++
        }
        return dp.last()
    }
}
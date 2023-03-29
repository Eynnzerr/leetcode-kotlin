package offer

class Solution60 {
    fun dicesProbability(n: Int): DoubleArray {
        // 思路：动态规划
        // m从1到n遍历，dp[i]表示m个骰子时，第i种点数和出现的概率
        // n个骰子，点数和取值范围为n~6n，共5n+1种可能取值，因此dp是个变长的二维数组
        var dp = DoubleArray(6) { 1 / 6.0 }
        if (n > 1) {
            for (m in 2..n) {
                // 利用条件概率f(n,x) = f(n-1,x-y) * (1 / 6), y in 1..6 依次计算前一轮每个点数和概率对当前轮各点数和概率的贡献
                val next =  DoubleArray(5 * m + 1)
                for (i in dp.indices) {
                    for (j in 0..5) {
                        next[i + j] += dp[i] / 6
                    }
                }
                dp = next
            }
        }
        return dp
    }
}
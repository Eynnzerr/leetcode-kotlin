package offer

import kotlin.math.max
import kotlin.math.min

class Solution63 {
    // 股票的最大利润
    fun maxProfit(prices: IntArray): Int {
        // dp[i]表示为到第i天为止能够卖出的最大利润
        // 遍历过程中需要保存遇到的最小值，也就是最适合作为买入价格的值
        // 则有dp[i] = max(dp[i-1], prices[i] - minVal)
        if (prices.isEmpty()) return 0
        val dp = IntArray(prices.size).apply{ this[0] = 0 }
        var minVal = prices[0]
        for (i in 1..prices.lastIndex) {
            minVal = min(minVal, prices[i])
            dp[i] = max(dp[i-1], prices[i] - minVal)
        }
        return dp.last()
    }
}
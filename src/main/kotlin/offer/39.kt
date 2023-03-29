package offer

class Solution39 {
    fun majorityElement(nums: IntArray): Int {
        // 摩尔投票法 时间O(1) 空间O(1) 面试最优解法
        var score = 0
        var common = nums[0]
        for (num in nums) {
            if (score == 0) {
                common = num
            }
            score += if (num == common) 1 else -1
        }
        return common
    }
}
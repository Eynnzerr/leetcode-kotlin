package offer

class Solution42 {
    fun maxSubArray(nums: IntArray): Int {
        // e.g. [-2,1,-3,4,-1,2,1,-5,4]
        // 原地dp nums[i]表示以i为终点，最大连续子数组和
        for (i in nums.indices) {
            if (i > 0 && nums[i-1] > 0)
                nums[i] += nums[i-1]
        }
        return nums.max()
    }
}
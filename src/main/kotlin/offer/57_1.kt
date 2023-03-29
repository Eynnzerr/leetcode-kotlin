package offer

class Solution57_1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // 思路：双指针法，left指针指向较小数，且只正向移动；right指针指向较大数，且只逆向移动
        var left = 0
        var right = nums.lastIndex
        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] > target) {
                // 大了 需要减小
                right --
            } else {
                // 小了，需要增大
                left ++
            }
        }
        return intArrayOf(nums[left], nums[right])
    }
}
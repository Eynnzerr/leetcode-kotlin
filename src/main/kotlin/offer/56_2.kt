package offer

class Solution56_2 {
    fun singleNumber(nums: IntArray): Int {
        // 难！！！
        // 思路模仿56.1 什么运算可以使 x ? x ? x = 0, x ? 0 = x
        // 推敲许久，这种运算是不存在的，故需要找另一种思路
        // 如何消除3次重复数的影响？试想，如果逐位将nums数组中某位上bit相加，再余3，是不是就能实现？
        // 简单证明： 假设某位上，待求数比特为x，当重复数在这位比特是1时，(x+1*3)%3=x；当重复数在这位比特是0时，(x+0*3)%3=x。故最后运算结果就是待求数比特
        // 各位拼起来就是待求数
        var mask = 1
        val bits = mutableListOf<Int>()
        while (mask != 0) {
            // 由于bit只取0/1，bit相加相当于统计1的个数。且注意：由于题目所给数组特性，求得结果只可能是0或1
            bits.add(nums.count { it and mask != 0 } % 3)
            mask = mask shl 1
        }
        return bits.reduceIndexed { index, acc, i -> acc or (i shl index) }
    }
}
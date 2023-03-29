package offer

class Solution56_1 {
    fun singleNumbers(nums: IntArray): IntArray {
        // 难！！！
        // 思路：要求时间O(n)，排除BF；要求空间O(1)，排除哈希表
        // 位运算法：求整个数组的累积异或。原因在于一个数异或本身得0，异或0得本身。又有异或的交换性，可得最终结果为cum=a^b，a和b即为仅出现一次的数字
        // 由于a!=b，cum必然不为0，找到cum最低的1位，并用这位作为掩码，以掩码结果1/0分割原先的数组为2个子数组，保证a和b分别在2个数组中
        // 接着对2个数组再求累积异或即可得到a和b
        val cum = nums.reduce { acc, i -> acc xor i }
        var lowOneBit = 1
        while (cum and lowOneBit == 0) {
            lowOneBit = lowOneBit shl 1
        }
        val arr1 = mutableListOf<Int>()
        val arr2 = mutableListOf<Int>()
        nums.forEach {
            if (it and lowOneBit == 0) arr1.add(it)
            else arr2.add(it)
        }
        return intArrayOf(arr1.reduce { acc, i -> acc xor i }, arr2.reduce { acc, i -> acc xor i })
    }
}
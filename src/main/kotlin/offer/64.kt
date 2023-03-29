package offer

class Solution64 {
    fun sumNums(n: Int): Int {
        // 递归很好想，怎么保证初始情况很难想 -> 利用逻辑运算短路特性
        // 但是kt中赋值结果不能作为逻辑值返回，所以不能用这种思路
        var res = n
        // val flag = res == 1 && res += sumNums(res - 1)
        return res
    }
}
package offer

class Solution44 {
    fun findNthDigit(n: Int): Int {
        // 找规律题，面试问到听天由命
        var dis = n  // 距起始数字还有多少数位
        var digit = 1  // 位数
        var count = 9  // 数位
        var start = 1  // 当前位数的数字集合起始数字
        while (n > count) {
            dis -= count
            digit ++
            start *= 10
            count = digit * start * 9
        }
        var number = start + (n - 1) / digit
        val bit = (n - 1) % digit
        while (bit < digit - 1) {
           number /= 10
            digit --
        }
        return number % 10
    }
}
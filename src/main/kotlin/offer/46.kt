package offer

class Solution46 {
    fun translateNum(num: Int): Int {
        return translateNumString2(num.toString())
    }

    // 法1. 直接递归
    fun translateNumString1(num: String): Int = if (num.length == 1) 1 else translateNumString1(num.drop(1)) + if (num.substring(0..1).toInt() in 0..25) translateNumString1(num.drop(2)) else 0

    // 法2. 直接递归存在大量重复子问题。自底向上循环可以消除
    fun translateNumString2(num: String): Int {
        val count = IntArray(num.length)
        for (i in num.lastIndex downTo 0) {
            if (i == num.lastIndex) {
                count[i] = 1
            } else {
                // i + 1 <= num.lastIndex
                count[i] = count[i+1]
                // i + 2 <= num.lastIndex
                if (num[i] != '0' && num.substring(i..(i+1)).toInt() in 0..25) {
                    if (i <= num.lastIndex - 2 ) {
                        count[i] += count[i+2]
                    } else {
                        count[i] += 1
                    }
                }
            }
        }
        return count[0]
    }
}
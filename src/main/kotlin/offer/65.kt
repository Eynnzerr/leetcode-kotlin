package offer

class Solution65 {
    fun add(a: Int, b: Int): Int {
        // 数字+数字=无进位和（位异或）+进位（位与左移1）
        var sum = a
        var carry = b // 把第二个相加的数字先看做进位！
        while (carry != 0) {
            val c = (sum and carry) shl 1 // 同一位上只有2个1才有进位，也就对应位与
            sum = sum xor carry
            carry = c
        }
        return sum
    }
}
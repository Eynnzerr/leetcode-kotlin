package offer

class Solution50 {
    fun firstUniqChar(s: String): Char {
        // 显然的做法：哈希表记录当前字符是否出现多次 + 2次遍历
        // 或使用有序哈希表 LinkedHashMap 第二次在哈希表上遍历即可
        val appearedOnce = mutableMapOf<Char, Boolean>()
        for (c in s) {
            appearedOnce[c] = !appearedOnce.contains(c)
        }
        return s.firstOrNull { appearedOnce[it] == true } ?: ' '
    }
}
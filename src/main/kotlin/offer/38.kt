package offer

class Solution38 {
    fun permutation(s: String): Array<String> {
        // 方法一 回溯+简单去重
        // 其它去重方案：哈希表、s排序+visited
        val res = mutableListOf<String>()
        permutation(s.toCharArray(), 0, res)
        return res.distinct().toTypedArray()
    }

    private fun permutation(s: CharArray, pos: Int, res: MutableList<String>) {
        if (pos == s.size - 1) {
            res.add(String(s))
        } else {
            // val set = mutableSetOf<Char>()
            for (i in pos until s.size) {
                // if (set.contains(s[i])) continue
                // set.add(s[i])
                // 交换当前固定位置，其实就相当于一个原地的visited数组
                var temp = s[i]
                s[i] = s[pos]
                s[pos] = temp

                permutation(s, pos + 1, res)

                // 回溯，恢复当前位置
                // 相当于visited数组中对应位置取消标记
                temp = s[i]
                s[i] = s[pos]
                s[pos] = temp
            }
        }
    }
}
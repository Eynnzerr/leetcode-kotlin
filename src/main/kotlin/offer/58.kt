package offer

import java.util.LinkedList

class Solution58 {
    fun reverseWords(s: String): String {
        val stack = LinkedList<String>()
        var start = 0
        while (start <= s.lastIndex) {
            // 找到一个单词的首字母
            while (start <= s.lastIndex && s[start] == ' ') {
                start ++
            }

            // 找不到首字母了，直接返回
            if (start > s.lastIndex || s[start] == ' ') break

            // 否则，继续找到其对应的尾字母
            var end = start
            while (end <= s.lastIndex && s[end] != ' ') {
                end ++
            }
            stack.push(s.substring(start, end))
            start = end
        }
        return with(StringBuilder()) {
            while (stack.isNotEmpty()) {
                append(stack.pop())
                if (stack.isNotEmpty()) {
                    append(' ')
                }
            }
            toString()
        }
    }

    // wrong
    fun reverseWords2(s: String) = with(StringBuilder()) {
        for (word in s.trim().split(" ").reversed()) {
            append(word)
            append(" ")
        }
        if (isNotEmpty()) deleteCharAt(lastIndex)
        toString()
    }
}

fun main() {
    print(Solution58().reverseWords("  hello world!  "))
}
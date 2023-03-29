package offer

class Solution58_2 {
    fun reverseLeftWords(s: String, n: Int): String {
        return s.substring(n) + s.substring(0, n)
    }
}
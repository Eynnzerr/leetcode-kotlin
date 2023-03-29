package offer

fun main() {
    val a: Int? = null
    println(test(a))
}

fun exchange(nums: IntArray): IntArray {
    // return nums.sortedBy { -(it % 2) }.toIntArray()
    var head = 0
    var tail = nums.size - 1
    while (head < tail) {
        while (head < tail && nums[head] % 2 == 1) {
            head ++
        }
        while (head < tail && nums[tail] % 2 == 0) {
            tail --
        }

        // Now that head is even and tail is odd, exchange them.
        if (head < tail) {
            val temp = nums[head]
            nums[head] = nums[tail]
            nums[tail] = temp
        }
        // after exchange, head is odd and tail is even.
    }
    return nums
}

fun test(a: Int?): Boolean {
    a ?: return false
    return true
}
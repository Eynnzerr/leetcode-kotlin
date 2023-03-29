package offer

import ListNode

class Solution24 {
    // 法一：循环
    fun reverseList1(head: ListNode?): ListNode? {
        var cur = head
        var prev: ListNode? = null
        while (cur != null) {
            val next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }

    // 法二：递归
    fun reverseList2(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return head

        val newHead = reverseList2(head.next)
        head.next?.next = head
        head.next = null
        return newHead
    }
}
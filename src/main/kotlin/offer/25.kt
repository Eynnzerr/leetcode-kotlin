package offer

import ListNode


class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var p1 = list1
        var p2 = list2
        val head = ListNode(0)
        var cur = head
        while(p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.`val` <= p2.`val`) {
                    cur.next = p1
                    p1 = p1.next
                } else {
                    cur.next = p2
                    p2 = p2.next
                }
                cur = cur.next!!
            }
            else if (p1 == null) {
                cur.next = p2
                break
            }
            else {
                cur.next = p1
                break
            }
        }
        return head.next
    }
}
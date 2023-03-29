package offer

import ListNode

class Solution52 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        // 时间O(m+n) 空间O(1) 做法：双指针
        if (headA == null || headB == null) return null
        var p1 = headA
        var p2 = headB
        while (p1 != p2) {
            p1 = p1?.next
            if (p1 == null) p1 = headB
            p2 = p2?.next
            if (p2 == null) p2 = headA
        }
        return p1
    }
}
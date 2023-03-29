package offer

// 力扣上这题没支持用kt写
class ComplexNode(
    var value: Int,
    var next: ComplexNode? = null,
    var random: ComplexNode? = null
)

fun copyRandomList(head: ComplexNode?): ComplexNode? {
    // 不使用辅助空间的O(n)解法：原地复制，再拆开为2个链表
    // step1. 原地复制链表主线
    var curNode = head
    while (curNode != null) {
        val clonedNode = ComplexNode(curNode.value, next = curNode.next)
        curNode.next = clonedNode
        curNode = clonedNode.next
    }
    //  step2. 为新链表设置random
    curNode = head
    while (curNode != null) {
        val clonedNode = curNode.next
        clonedNode?.random = curNode.random?.next
        curNode = clonedNode?.next
    }
    // step3. 断开两表的连接
    curNode = head
    var clonedHead = head?.next
    val res = head?.next
    while (curNode != null) {
        curNode.next = clonedHead?.next
        curNode = curNode.next
        clonedHead?.next = curNode?.next
        clonedHead = clonedHead?.next
    }
    return res
}
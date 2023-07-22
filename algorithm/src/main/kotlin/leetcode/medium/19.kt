package leetcode.medium

class `19` {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummyHead =  ListNode(`val` = 0).apply { next = head }
        var left: ListNode? = dummyHead
        var right: ListNode? = dummyHead

        repeat(IntRange(0, n - 1).count()) { right = right?.next }
        while (right?.next != null) {
            left = left?.next
            right = right?.next
        }
        left?.next = left?.next?.next
        return dummyHead.next
    }
}

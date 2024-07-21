package leetcode.medium

class `2095` {
    fun deleteMiddle(head: ListNode_2095?): ListNode_2095? {
        if (head?.next == null) {
            return null
        }

        var slow = head
        var fast = head.next?.next

        while (fast != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        if (fast?.next != null) {
            slow?.next?.next = slow?.next?.next?.next
        } else {
            slow?.next = slow?.next?.next
        }
        return head
    }
}

class ListNode_2095(var `val`: Int) {
    var next: ListNode_2095? = null
}

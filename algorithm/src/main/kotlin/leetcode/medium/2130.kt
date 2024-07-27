package leetcode.medium


class `2130` {
    fun pairSum(head: ListNode_2130?): Int {
        val half = getHalf(head)
        val reversed = getReversed(half)

        var max = 0
        var start = head
        var previous = reversed
        while (previous != null) {
            max = maxOf(max, start!!.`val` + previous.`val`)
            previous = previous.next
            start = start.next
        }
        return max
    }

    private fun getHalf(head: ListNode_2130?): ListNode_2130? {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

    private fun getReversed(half: ListNode_2130?): ListNode_2130? {
        var previous: ListNode_2130? = null
        var current = half

        while (current != null) {
            val temp = current.next
            current.next = previous
            previous = current
            current = temp
        }

        return previous
    }
}

data class ListNode_2130(var `val`: Int) {
    var next: ListNode_2130? = null
}

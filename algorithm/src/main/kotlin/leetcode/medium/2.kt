package leetcode.medium

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class `2` {
    fun addTwoNumbers(
        l1: ListNode?,
        l2: ListNode?,
        carry: Int = 0,
    ): ListNode? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }
        val calculated = (l1.value()) + (l2.value()) + carry
        return ListNode(
            `val` = calculated % 10,
        ).apply {
            next = addTwoNumbers(
                l1 = l1?.next,
                l2 = l2?.next,
                carry = calculated / 10,
            )
        }
    }

    private fun ListNode?.value(): Int {
        return this?.`val` ?: 0
    }
}

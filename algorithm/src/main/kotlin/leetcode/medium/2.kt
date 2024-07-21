package leetcode.medium

class ListNode(var `val`: Int) {
    var next: ListNode_2095? = null
}

class `2` {
    fun addTwoNumbers(
        l1: ListNode_2095?,
        l2: ListNode_2095?,
        carry: Int = 0,
    ): ListNode_2095? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }
        val calculated = (l1.value()) + (l2.value()) + carry
        return ListNode_2095(
            `val` = calculated % 10,
        ).apply {
            next = addTwoNumbers(
                l1 = l1?.next,
                l2 = l2?.next,
                carry = calculated / 10,
            )
        }
    }

    private fun ListNode_2095?.value(): Int {
        return this?.`val` ?: 0
    }
}

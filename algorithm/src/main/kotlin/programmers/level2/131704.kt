package programmers.level2

import java.util.Stack

class Solution131704 {
    fun solution(order: IntArray): Int {
        val truck = mutableListOf<Int>()
        val assistant = Stack<Int>()
        var orderIndex = 0
        for (i in order.indices) {
            val deliveryNumber = i + 1

            if (order[orderIndex] != deliveryNumber) {
                assistant.add(deliveryNumber)
            } else {
                truck.add(deliveryNumber)
                orderIndex += 1
                while (assistant.isNotEmpty() && assistant.peek() == order[orderIndex]) {
                    truck.add(assistant.pop())
                    orderIndex += 1
                }
            }
        }
        return truck.size
    }
}

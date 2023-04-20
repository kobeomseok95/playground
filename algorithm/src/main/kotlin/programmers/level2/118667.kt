package programmers.level2

import java.util.*

class Solution118667 {
    fun solution(
        queue1: IntArray,
        queue2: IntArray,
    ): Int {
        var answer: Int = 0
        val limit = queue1.size * 3
        var left = queue1.sum().toLong()
        var right = queue2.sum().toLong()
        val q1 = LinkedList(queue1.toList())
        val q2 = LinkedList(queue2.toList())
        while (true) {
            if (answer > limit) {
                return -1
            }
            if (left > right) {
                val pop = q1.pop()
                left -= pop
                right += pop
                q2.add(pop)
                answer += 1
            } else if(left < right) {
                val pop = q2.pop()
                left += pop
                right -= pop
                q1.add(pop)
                answer += 1
            } else {
                break
            }
        }
        return answer
    }
}

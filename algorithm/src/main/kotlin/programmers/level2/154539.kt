package programmers.level2

import java.util.*

class Solution154539 {
    fun solution(numbers: IntArray): IntArray {
        val size = numbers.size
        val stack = Stack<Int>()
        val answer = IntArray(size) { -1 }

        for (i in 0 until size) {
            while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.add(i)
        }

        return answer
    }
}

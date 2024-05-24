package leetcode.medium

import java.util.Stack

class `2390` {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()
        s.forEach { char ->
            stack.add(char)
            if (stack.peek() == STAR) {
                stack.pop()
                stack.pop()
            }
        }
        return stack.joinToString(separator = "")
    }

    companion object {
        private const val STAR = '*'
    }
}

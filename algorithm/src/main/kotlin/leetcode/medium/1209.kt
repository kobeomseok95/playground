package leetcode.medium

import java.util.*


class `1209` {
    fun removeDuplicates(s: String, k: Int): String {
        val stack = Stack<CharacterCount>()
        s.forEach { c ->
            val count = if (stack.isNotEmpty() && stack.last().alphabet == c) stack.last().count + 1 else 1
            stack.push(
                CharacterCount(
                    alphabet = if (stack.isNotEmpty() && stack.last().alphabet == c) stack.pop().alphabet else c,
                    count = count,
                )
            )
            while (stack.isNotEmpty() && stack.peek().count >= k) {
                stack.pop()
            }
        }
        return stack.joinToString("") { it.alphabet.toString().repeat(it.count) }
    }

    data class CharacterCount(
        val alphabet: Char,
        val count: Int,
    )
}

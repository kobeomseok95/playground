package leetcode.medium

class `5` {
    fun longestPalindrome(s: String): String {
        var answer = ""
        for (i in s.indices) {
            val resultOdd = s.checkPalindrome(i, i)
            val resultEven = s.checkPalindrome(i, i + 1)
            answer = if (answer.length < resultOdd.length) resultOdd else answer
            answer = if (answer.length < resultEven.length) resultEven else answer
        }
        return answer
    }

    private fun String.checkPalindrome(left: Int, right: Int): String {
        var idx = -1
        for (i in this.indices) {
            if (left - i < 0 || right + i >= this.length) {
                break
            }
            if (this[left - i] != this[right + i]) {
                break
            }
            idx = i
        }
        return if (idx == -1) "" else this.substring(left - idx..right + idx)
    }
}

fun main() {
    `5`().apply {
        longestPalindrome("babad").apply(::println)
        longestPalindrome("cbbd").apply(::println)
    }
}

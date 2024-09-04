package programmers.level3

class `12904` {
    fun solution(s: String): Int {
        var answer = 0
        s.indices.forEach {
            answer = answer.coerceAtLeast(
                getMaxPalindromeLength(s, it, it)
            ).coerceAtLeast(
                getMaxPalindromeLength(s, it, it + 1)
            )
        }
        return answer
    }

    private fun getMaxPalindromeLength(s: String, left: Int, right: Int): Int {
        var leftIndex = left
        var rightIndex = right

        while (leftIndex >= 0 && rightIndex < s.length && s[leftIndex] == s[rightIndex]) {
            leftIndex -= 1
            rightIndex += 1
        }

        return rightIndex - leftIndex - 1
    }
}

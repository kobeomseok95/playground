package leetcode.medium

class `1888` {
    private lateinit var alternativeStrings: List<String>

    fun minFlips(s: String): Int {
        setAlternativeString(s.length)
        return getDifferentCount(s)
    }

    private fun setAlternativeString(length: Int) {
        alternativeStrings = listOf(
            "10".repeat(length),
            "01".repeat(length),
        )
    }

    private fun getDifferentCount(s: String): Int {
        val newStr = s + s
        val alter1 = alternativeStrings[0]
        val alter2 = alternativeStrings[1]
        var diff1 = 0
        var diff2 = 0
        var left = 0
        var answer = s.length
        newStr.indices.forEach { right ->
            if (newStr[right] != alter1[right]) {
                diff1 += 1
            }
            if (newStr[right] != alter2[right]) {
                diff2 += 1
            }

            if ((right - left + 1) > s.length) {
                if (newStr[left] != alter1[left]) {
                    diff1 -= 1
                }
                if (newStr[left] != alter2[left]) {
                    diff2 -= 1
                }

                left += 1
            }

            if ((right - left + 1) == s.length) {
                answer = minOf(answer, diff1, diff2)
            }
        }

        return answer
    }
}

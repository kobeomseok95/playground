package leetcode.medium

class `424` {
    fun characterReplacement(s: String, k: Int): Int {
        val alphabetMap = mutableMapOf<Char, Int>()
        var left = 0
        var maxAlphabetCount = 0
        var maxLength = 0
        s.forEachIndexed { right, alphabet ->
            alphabetMap[alphabet] = alphabetMap.getOrDefault(alphabet, 0) + 1
            maxAlphabetCount = maxAlphabetCount.coerceAtLeast(alphabetMap.getOrDefault(alphabet, 0))

            if ((right - left + 1 - maxAlphabetCount) > k) {
                alphabetMap[s[left]] = alphabetMap.getOrDefault(s[left], 0) - 1
                left += 1
            }

            maxLength = maxLength.coerceAtLeast(right - left + 1)
        }
        return maxLength
    }
}

package leetcode.medium

class `3` {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }

        var start = 0
        var end = 0
        var answer = 1
        val characterSet = mutableSetOf<Char>()
        val stringArray = s.toCharArray()
        while (end < s.length) {
            if (characterSet.contains(stringArray[end])) {
                characterSet.remove(stringArray[start])
                start += 1
            } else {
                characterSet.add(stringArray[end])
                answer = answer.coerceAtLeast(characterSet.size)
                end += 1
            }
        }
        return answer
    }
}

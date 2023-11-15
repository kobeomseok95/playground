package leetcode.medium


class `2024` {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var i = 0
        val answerKeyMap = mutableMapOf(
            'T' to 0,
            'F' to 0,
        )
        var maxFrequency = 0

        answerKey.forEachIndexed { j, key ->
            answerKeyMap[key] = answerKeyMap[key]!! + 1
            maxFrequency = maxOf(maxFrequency, answerKeyMap[key]!!)
            if (j - i + 1 > maxFrequency + k) {
                answerKeyMap[answerKey[i]] = answerKeyMap[answerKey[i]]!! - 1
                i += 1
            }
        }

        return answerKey.length - i
    }
}

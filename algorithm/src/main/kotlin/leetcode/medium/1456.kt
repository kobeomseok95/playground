package leetcode.medium

class `1456` {
    fun maxVowels(s: String, k: Int): Int {
        var first = 0
        var last = k - 1
        var max = 0
        val vowelLettersCount = IntArray(s.length).apply {
            (first..last).forEach { i ->
                this[i] = if (s[i] in vowelLetters) {
                    this.getOrElse(i - 1) { 0 } + 1
                } else {
                    this.getOrElse(i - 1) { 0 }
                }
                max = maxOf(max, this[i])
            }
        }

        (k until s.length).forEach { i ->
            val vowelDeleted = s[first] in vowelLetters
            first += 1
            last += 1
            val vowelAdded = s[last] in vowelLetters
            val count = if (vowelDeleted && !vowelAdded) {
                vowelLettersCount[i - 1] - 1
            } else if (!vowelDeleted && vowelAdded) {
                vowelLettersCount[i - 1] + 1
            } else {
                vowelLettersCount[i - 1]
            }
            vowelLettersCount[i] = count
            max = maxOf(max, vowelLettersCount[i])
        }

        return max
    }

    companion object {
        private val vowelLetters = setOf('a', 'e', 'i', 'o', 'u')
    }
}

class `1456_2` {
    fun maxVowels(s: String, k: Int): Int {
        var value = 0
        (0 until k).forEach { i ->
            value += getValueIfVowelCharacter(s[i])
        }

        var maxValue = value
        (k until s.length).forEach { i ->
            value = value - getValueIfVowelCharacter(s[i - k]) + getValueIfVowelCharacter(s[i])
            maxValue = maxOf(value, maxValue)
        }

        return maxValue
    }

    private fun getValueIfVowelCharacter(c: Char): Int {
        return if (c.isVowel()) {
            1
        } else {
            0
        }
    }

    private fun Char.isVowel(): Boolean {
        return this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'
    }
}

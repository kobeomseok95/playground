package leetcode.medium

class `1657` {
    fun closeStrings(word1: String, word2: String): Boolean {
        val vector1 = word1.fold(IntArray(26)) { acc, c ->
            acc[c - 'a'] += 1
            acc
        }
        val vector2 = word2.fold(IntArray(26)) { acc, c ->
            acc[c - 'a'] += 1
            acc
        }

        for (i in vector1.indices) {
            if (vector1[i] == 0 && vector2[i] != 0 || vector1[i] != 0 && vector2[i] == 0) {
                return false
            }
        }

        vector1.sort()
        vector2.sort()

        for (i in vector1.indices) {
            if (vector1[i] != vector2[i]) {
                return false
            }
        }

        return true
    }
}

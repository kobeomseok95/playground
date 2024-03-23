package leetcode.easy


private class `1768` {
    fun mergeAlternately(word1: String, word2: String): String {
        val min = minOf(word1.length, word2.length)
        val word1IsLongest = word1.length >= word2.length
        val merged = (0 until min).joinToString("") { i ->
            word1[i].toString() + word2[i].toString()
        }
        return merged + if (word1IsLongest) {
            word1.substring(min)
        } else {
            word2.substring(min)
        }
    }

    fun mergeAlternatelyV2(word1: String, word2: String): String {
        val builder = StringBuilder()
        var cursor1 = 0
        var cursor2 = 0
        while (cursor1 < word1.length && cursor2 < word2.length) {
            builder.append(word1[cursor1++]).append(word2[cursor2++])
        }
        builder.append(word1.substring(cursor1)).append(word2.substring(cursor2))
        return builder.toString()
    }
}

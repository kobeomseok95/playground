package leetcode.medium

class `1143` {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val length1 = text1.length
        val length2 = text2.length
        val map = Array(length1 + 1) { IntArray(length2 + 1) { 0 } }
        (1..length1).forEach { i ->
            (1..length2).forEach { j ->
                if (text1[i - 1] == text2[j - 1]) {
                    map[i][j] = map[i - 1][j - 1] + 1
                } else {
                    map[i][j] = maxOf(map[i - 1][j], map[i][j - 1])
                }
            }
        }
        return map[length1][length2]
    }
}

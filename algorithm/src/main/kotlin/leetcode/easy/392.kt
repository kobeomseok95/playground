package leetcode.easy

class `392` {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isBlank()) {
            return true
        }
        val sChar = s.toCharArray()
        var sIndex = 0
        val tChar = t.toCharArray()

        tChar.indices.forEach { i ->
            if (sChar[sIndex] == tChar[i]) {
                sIndex += 1
            }
            if (sIndex == sChar.size) {
                return true
            }
        }

        return false
    }
}

package leetcode.medium

class `151` {
    fun reverseWords(s: String): String {
        return s.trim()
            .replace("\\s+".toRegex(), " ")
            .split(" ")
            .reversed()
            .joinToString(" ")
    }
}

class `151_2` {
    fun reverseWords(s: String): String {
        val stringBuilder = StringBuilder()
        val reversed = s.trim()
            .replace("\\s+".toRegex(), " ")
            .split(" ")
            .reversed()
        return reversed.forEachIndexed { index, word ->
            if (reversed.lastIndex != index) {
                stringBuilder.append("$word ")
            } else {
                stringBuilder.append(word)
            }
        }.run {
            stringBuilder.toString()
        }
    }
}

class `151_3` {
    fun reverseWords(s: String): String {
        val words = s.trim().replace("\\s+".toRegex(), " ").split(" ").toTypedArray()
        var (left, right) = Pair(0, words.size - 1)
        while (left < right) {
            words[left] = words[right].also{
                words[right--] = words[left++]
            }
        }
        return words.joinToString(" ")
    }
}

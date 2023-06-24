package leetcode.medium

import java.util.Collections.min

class `2515` {
    fun closetTarget(words: Array<String>, target: String, startIndex: Int): Int {
        val size = words.size
        val wordDistanceMap = mutableMapOf<String, MutableList<Int>>()
        IntRange(0, size - 1).forEach { index ->
            val searchIndex = (index + startIndex) % size
            if (wordDistanceMap[words[searchIndex]] == null) {
                wordDistanceMap[words[searchIndex]] = mutableListOf()
            }
            wordDistanceMap[words[searchIndex]]?.apply {
                add(index)
                add(size - index)
            }
        }

        return wordDistanceMap[target]?.let { min(it) } ?: -1
    }
}

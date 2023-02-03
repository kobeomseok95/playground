package programmers.level2

class Solution64065 {
    fun solution(s: String): IntArray = s.substring(1, s.length - 1)
        .split("},{")
        .map {
            it.replace("{", "")
                .replace("}", "")
                .split(",")
                .map { number -> number.toInt() }
        }
        .toList()
        .sortedBy { it.size }
        .fold(setOf<Int>()) { acc, list ->
            acc.union(list)
        }
        .toIntArray()
}

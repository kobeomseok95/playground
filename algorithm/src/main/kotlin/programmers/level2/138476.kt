package programmers.level2

data class TangerineCount(
    val size: Int,
    val count: Int,
)

class Solution138476 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        var limit = 0

        tangerine.groupBy { it }
            .toList()
            .map {
                TangerineCount(
                    size = it.first,
                    count = it.second.size
                )
            }
            .sortedByDescending { it.count }
            .forEach {
                if (limit >= k) {
                    return answer
                }
                limit += it.count
                answer = answer.inc()
            }
        return answer
    }
}

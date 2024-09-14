package boj.gold

/**
 * 1 2 3 3 2 1 -> 12가 나와야한다. 왜 20이 나올까
 */
class `13144` {
    fun solution(length: Int, sequence: List<Int>): Long {
        val numbers = BooleanArray(100_001)
        numbers[sequence[0]] = true
        var count: Long = 0
        var end = 0

        sequence.indices.forEach { i ->
            while (end < length - 1 && !numbers[sequence[end + 1]]) {
                end += 1
                numbers[sequence[end]] = true
            }
            count += end - i + 1
            numbers[sequence[i]] = false
        }

        return count
    }
}

fun main() {
    val n = readln().toInt()
    val sequence = readln().split(" ").map { it.toInt() }
    println(`13144`().solution(n, sequence))
}

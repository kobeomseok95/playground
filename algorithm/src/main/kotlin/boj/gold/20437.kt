package boj.gold

class `20437` {
    fun solution(w: String, k: Int): List<Int> {
        if (k == 1) {
            return listOf(1, 1)
        }

        val charArray = Array(26) { mutableListOf<Int>() }
        w.forEachIndexed { index, c -> charArray[c - 'a'].add(index) }

        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        (0 until 26).forEach { charArrayIndex ->
            if (charArray[charArrayIndex].size < k) {
                return@forEach
            }

            (0..(charArray[charArrayIndex].size - k)).forEach { index ->
                val a = charArray[charArrayIndex][index]
                val b = charArray[charArrayIndex][index + k - 1]
                min = min.coerceAtMost(b - a + 1)
                max = max.coerceAtLeast(b - a + 1)
            }
        }

        return if (min != Int.MAX_VALUE && max != Int.MIN_VALUE) {
            listOf(min, max)
        } else {
            listOf(-1)
        }
    }
}

fun main() {
    val t = readln().toInt()
    val results = (1..t).map {
        val w = readln()
        val k = readln().toInt()
        `20437`().solution(w, k)
    }
    results.forEach { println(it.joinToString(" ")) }
}

package programmers.level2

import kotlin.math.sqrt

class Solution140107 {
    fun solution(k: Int, d: Int): Long {
        var answer = 0L
        for (y in 0..d step(k)) {
            val maxX = sqrt((power(d) - power(y)).toDouble()).toLong()
            answer += (maxX / k) + 1
        }
        return answer
    }

    private fun power(number: Int): Long {
        return number.toLong() * number.toLong()
    }
}

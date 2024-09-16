package boj.silver

class `2531` {
    fun solution(
        sushiCount: Int,
        typesCount: Int,
        inARowEatCount: Int,
        couponNumber: Int,
        sushi: List<Int>,
    ): Int {
        val linkedSushi = sushi + sushi.take(inARowEatCount - 1)
        val eaten = IntArray(typesCount + 1)
        eaten[couponNumber] += 1
        var left = 0
        var right = 0
        var count = 1
        var max = 1

        while (right < linkedSushi.size) {
            if (eaten[linkedSushi[right]] == 0) {
                count += 1
            }
            eaten[linkedSushi[right]] += 1
            right += 1

            if (right - left > inARowEatCount) {
                eaten[linkedSushi[left]] -= 1
                if (eaten[linkedSushi[left]] == 0) {
                    count -= 1
                }
                left += 1
            }

            max = max.coerceAtLeast(count)
            if (max == typesCount + 1) {
                break
            }
        }
        return max
    }
}

fun main() {
    val (n, d, k, c) = readln().split(" ").map { it.toInt() }
    val sushi = (1..n).map { readln().toInt() }
    println(`2531`().solution(n, d, k, c, sushi))
}

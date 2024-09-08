package boj.silver

fun solution(kg: Int): Int {
    val dp = IntArray(kg + 5) { 1e9.toInt() }
    val result = recursive(0, dp, kg)
    return when (dp[0]) {
        1e9.toInt() -> -1
        else -> result
    }
}

fun recursive(weight: Int, dp: IntArray, kg: Int): Int {
    if (weight == kg) {
        return 0
    }
    if (weight > kg) {
        return 1e9.toInt()
    }
    if (dp[weight] != 1e9.toInt()) {
        return dp[weight]
    }

    var result = 1e9.toInt()
    result = result.coerceAtMost(recursive(weight + 3, dp, kg) + 1)
    result = result.coerceAtMost(recursive(weight + 5, dp, kg) + 1)
    dp[weight] = result
    return result
}

fun main() {
    val n = readln().toInt()
    println(solution(n))
}

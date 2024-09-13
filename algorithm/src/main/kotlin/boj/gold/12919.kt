package boj.gold

class `12919` {
    fun solution(s: String, t: String): Int {
        val result = dfs(start = t, end = s)
        return if (result >= 1) {
            1
        } else {
            0
        }
    }

    fun dfs(start: String, end: String): Int {
        if (start.length == end.length) {
            return if (start == end) {
                1
            } else {
                0
            }
        }

        val result1 = if (start.last() == 'A') {
            dfs(start = start.substring(0, start.length - 1), end = end)
        } else {
            0
        }
        val result2 = if (start.first() == 'B') {
            dfs(start = start.reversed().substring(0, start.length - 1), end = end)
        } else {
            0
        }
        return result1 + result2
    }
}

fun main() {
    val s = readln()
    val t = readln()
    println(`12919`().solution(s, t))
}

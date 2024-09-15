package boj.silver

class `17615` {
    fun solution(n: Int, balls: String): Int {
        val blue = balls.count { it == 'B' }
        val red = n - blue
        var answer = blue.coerceAtMost(red)

        var count = 0
        while (count < balls.length && balls[0] == balls[count]) {
            count += 1
        }
        if (balls[0] == 'R') {
            answer = answer.coerceAtMost(red - count)
        } else {
            answer = answer.coerceAtMost(blue - count)
        }

        count = 0
        while (count < balls.length && balls.last() == balls[balls.lastIndex - count]) {
            count += 1
        }
        if (balls.last() == 'R') {
            answer = answer.coerceAtMost(red - count)
        } else {
            answer = answer.coerceAtMost(blue - count)
        }

        return answer
    }
}

fun main() {
    val n = readln().toInt()
    val balls = readln()
    println(`17615`().solution(n, balls))
}

package boj.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val input = StringTokenizer(br.readLine())
        val n = input.nextToken().toInt()
        val m = input.nextToken().toInt()
        val docs = StringTokenizer(br.readLine())
        val priority = IntArray(10)
        val q = LinkedList<Pair<Int, Int>>().apply {
            for (i in 0 until n) {
                val next = docs.nextToken().toInt()
                add(i to next)
                priority[next]++
            }
        }

        var count = 0
        while (!q.isEmpty()) {
            val poll = q.poll()
            if (isMax(poll.second, priority)) {
                priority[poll.second]--
                count++
                if (poll.first == m) {
                    println(count)
                    break
                }
            } else {
                q.add(poll)
            }
        }
    }
}

fun isMax(
    value: Int,
    priority: IntArray,
): Boolean {
    var result = false
    for (i in 9 downTo 1) {
        if (priority[i] > 0) {
            if (value == i) {
                result = true
            }
            break
        }
    }
    return result
}

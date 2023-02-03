package boj.silver

import java.util.LinkedList

fun solution(
    findIndex: Int,
    case: String,
): Int {
    var find = findIndex
    var count = 0
    val queue = LinkedList<Int>().apply {
        case.split(" ")
            .forEach { add(it.toInt()) }
    }

    while (queue.size > 0) {
        val max = queue.maxOrNull()
        val front = queue.pollFirst()
        find -= 1

        if (max == front) {
            count += 1
            if (find < 0) {
                return count
            }
        } else {
            queue.add(front)
            if (find < 0) {
                find = queue.size - 1
            }
        }

    }
    return count
}

fun main() {
    var test = readLine()!!.toInt()
    while (test > 0) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val case = readLine()!!
        println(solution(m, case))
        test--
    }
}

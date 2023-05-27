package programmers.level3

import java.lang.IllegalArgumentException
import java.util.PriorityQueue

enum class Operator {
    I {
        override fun operation(
            minQ: PriorityQueue<Int>,
            maxQ: PriorityQueue<Int>,
            number: Int,
        ) {
            minQ.add(number)
            maxQ.add(number)
        }
    },
    D {
        override fun operation(
            minQ: PriorityQueue<Int>,
            maxQ: PriorityQueue<Int>,
            number: Int,
        ) {
            when (number) {
                1 -> {
                    val polled = maxQ.poll()
                    minQ.remove(polled)
                }
                -1 -> {
                    val polled = minQ.poll()
                    maxQ.remove(polled)
                }
                else -> throw IllegalArgumentException()
            }
        }
    },
    ;

    abstract fun operation(
        minQ: PriorityQueue<Int>,
        maxQ: PriorityQueue<Int>,
        number: Int,
    )
}

class Solution42628 {
    fun solution(operations: Array<String>): List<Int> {
        val maxQ = PriorityQueue<Int>(Comparator.reverseOrder())
        val minQ = PriorityQueue<Int>()
        operations.forEach { operation ->
            val (operator, number) = operation.split(" ")
            Operator.valueOf(operator).operation(minQ, maxQ, number.toInt())
        }
        return if (minQ.isEmpty() && maxQ.isEmpty()) {
            listOf(0, 0)
        } else {
            listOf(
                maxQ.poll(),
                minQ.poll(),
            )
        }
    }
}

class Solution42628_2 {
    fun solution(operations: Array<String>): List<Int> {
        val q = arrayListOf<Int>()
        operations.forEach { operation ->
            val (operator, number) = operation.split(" ")
            when (operator) {
                "I" -> q.add(number.toInt())
                "D" -> {
                    val value = if (number.toInt() == 1) {
                        q.maxOrNull()
                    } else {
                        q.minOrNull()
                    }
                    value?.let { q.remove(it) }
                }
            }
        }
        return if (q.isEmpty()) {
            listOf(0, 0)
        } else {
            q.sort()
            listOf(q[q.size - 1], q[0])
        }
    }
}

fun main() {
    val s = Solution42628_2()
    s.solution(
        operations = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"),
    ).onEach(::println)
    s.solution(
        operations = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"),
    ).onEach(::println)
}

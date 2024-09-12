package boj.gold

import java.util.PriorityQueue

class `5972` {
    fun solution(
        end: Int,
        edges: List<List<Int>>,
    ): Int {
        val graph = createGraph(edges)
        val visitedDists = IntArray(end + 1) { Int.MAX_VALUE }
        val queue = PriorityQueue<To>().apply {
            add(To(1, 0))
            visitedDists[1] = 0
        }

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current.to == end) {
                return current.cost
            }

            graph[current.to].orEmpty().forEach {
                if (visitedDists[it.to] > current.cost + it.cost) {
                    val dist = current.cost + it.cost
                    queue.add(To(it.to, dist))
                    visitedDists[it.to] = dist
                }
            }
        }

        return 0
    }

    private fun createGraph(edges: List<List<Int>>): Map<Int, List<To>> {
        val graph = mutableMapOf<Int, MutableList<To>>()
        edges.forEach { (a, b, c) ->
            graph[a]?.add(To(b, c)) ?: graph.put(a, mutableListOf(To(b, c)))
            graph[b]?.add(To(a, c)) ?: graph.put(b, mutableListOf(To(a, c)))
        }
        return graph
    }

    data class To(
        val to: Int,
        val cost: Int,
    ) : Comparable<To> {
        override fun compareTo(other: To): Int {
            return cost - other.cost
        }
    }
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val edges = (1..m).map {
        val (a, b, c) = readln().split(" ").map { it. toInt() }
        listOf(a, b, c)
    }
    println(`5972`().solution(n, edges))
}

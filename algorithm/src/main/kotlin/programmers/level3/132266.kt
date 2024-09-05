package programmers.level3

import java.util.LinkedList

class `132266` {
    fun solution(
        n: Int,
        roads: Array<IntArray>,
        sources: IntArray,
        destination: Int,
    ): IntArray {
        val graph = createGraph(n, roads)
        val distances = getMinimumDistances(
            n = n,
            start = destination,
            graph = graph,
        )
        return sources.map { distances[it] }.toIntArray()
    }

    private fun createGraph(n: Int, roads: Array<IntArray>): Map<Int, Set<Int>> {
        val graph = (1..n).associateWith { mutableSetOf<Int>() }
        roads.forEach { road ->
            val (a, b) = road
            graph[a]?.add(b)
            graph[b]?.add(a)
        }
        return graph
    }

    private fun getMinimumDistances(
        n: Int,
        start: Int,
        graph: Map<Int, Set<Int>>,
    ): IntArray {
        val distances = IntArray(n + 1) { -1 }
        val queue = LinkedList<Int>().apply {
            add(start)
            distances[start] = 0
        }

        while (queue.isNotEmpty()) {
            val current = queue.pop()
            graph[current].orEmpty().forEach { next ->
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1
                    queue.add(next)
                }
            }
        }

        return distances
    }
}

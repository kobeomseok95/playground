package leetcode.medium

import java.util.PriorityQueue
import kotlin.math.absoluteValue


class `1584` {
    private lateinit var parent: IntArray

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        parent = IntArray(points.size) { it }
        val size = points.size
        val edges = PriorityQueue<Edge>().apply {
            (0 until size).forEach { i ->
                (0 until size).forEach { j ->
                    add(
                        Edge(
                            u = i,
                            v = j,
                            distance = getManhattanDistance(points[i], points[j]),
                        ),
                    )
                }
            }
        }

        var answer = 0

        while (edges.isNotEmpty()) {
            val edge = edges.poll()
            if (find(edge.u) != find(edge.v)) {
                union(edge)
                answer += edge.distance
            }
        }

        return answer
    }

    private fun getManhattanDistance(a: IntArray, b: IntArray): Int =
        (a[0] - b[0]).absoluteValue + (a[1] - b[1]).absoluteValue

    private fun find(point: Int): Int {
        if (parent[point] != point) {
            parent[point] = find(parent[point])
        }
        return parent[point]
    }


    private fun union(edge: Edge) {
        val rootA = find(edge.u)
        val rootB = find(edge.v)
        if (rootA != rootB) {
            parent[rootA] = rootB
        }
    }

    data class Edge(
        val u: Int,
        val v: Int,
        val distance: Int,
    ) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            if (this.distance < other.distance) {
                return -1
            } else if (this.distance > other.distance) {
                return 1
            }
            return 0
        }
    }
}

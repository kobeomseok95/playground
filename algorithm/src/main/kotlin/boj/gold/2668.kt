package boj.gold

class `2668` {
    fun solution(n: Int, numbers: List<Int>): List<Int> {
        val visited = BooleanArray(n + 1)
        val result = mutableListOf<Int>()
        (1..n).forEach { i ->
            visited[i] = true
            dfs(i, i, numbers, result, visited)
            visited[i] = false
        }

        return result
    }

    private fun dfs(start: Int, target: Int, numbers: List<Int>, result: MutableList<Int>, visited: BooleanArray) {
        if (!visited[numbers[start]]) {
            visited[numbers[start]] = true
            dfs(numbers[start], target, numbers, result, visited)
            visited[numbers[start]] = false
        }

        if (numbers[start] == target) {
            result.add(target)
        }
    }
}

fun main() {
    val n = readln().toInt()
    val numbers = listOf(0) + (0 until n).map { readln().toInt() }
    val result = `2668`().solution(n, numbers)
    println(result.size)
    result.forEach(::println)
}

package boj.gold

import kotlin.math.absoluteValue

class `7490` {
    fun solution(test: Int): List<String> {
        val permutation = (1..test).toList()
        return dfs(permutation)
    }

    fun dfs(
        permutation: List<Int>,
        expressions: List<Int> = listOf(1),
        index: Int = 1,
    ): List<String> {
        if (index >= permutation.size) {
            return if (expressions.sum() == 0) {
                listOf(convert(expressions))
            } else {
                listOf()
            }
        }

        val number = permutation[index]
        val a = dfs(permutation, expressions + listOf(number), index + 1)
        val b = dfs(permutation, expressions + listOf(-number), index + 1)
        val c = dfs(
            permutation,
            expressions.dropLast(1) + listOf("${expressions.last()}$number".toInt()),
            index + 1,
        )
        return (a + b + c).toSet().sorted()
    }

    private fun convert(expressions: List<Int>): String {
        var converted = ""
        expressions.forEachIndexed { index, value ->
            if (index == 0) {
                if (value >= 0) {
                    converted += "$value".toList().joinToString(" ")
                } else {
                    converted += "$value"
                }
            } else {
                if (value >= 0) {
                    converted += '+'
                    converted += value.toString().toList().joinToString(" ")
                } else {
                    converted += '-'
                    converted += value.absoluteValue.toString().toList().joinToString(" ")
                }
            }
        }
        return converted
    }
}

fun main() {
    val test = readln().toInt()
    val tests = (1..test).map { readln().toInt() }
    val solution = `7490`()
    tests.forEachIndexed { index, it ->
        solution.solution(it).forEach {
            println(it)
        }
        if (index != tests.size - 1) {
            println()
        }
    }
}

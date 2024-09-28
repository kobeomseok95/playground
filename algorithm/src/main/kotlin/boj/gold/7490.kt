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

class `7490_2` {
    fun solution(
        n: Int,
        index: Int,
        number: Int,
        sum: Int,
        operator: Int,
        expression: String,
    ): List<String> {
        if (index == n) {
            if (sum + (number * operator) == 0) {
                return listOf(expression)
            }
            return listOf()
        }

        val a = solution(
            n = n,
            index = index + 1,
            number = number * 10 + (index + 1),
            sum = sum,
            operator = operator,
            expression = "$expression ${index + 1}",
        )
        val b = solution(
            n = n,
            index = index + 1,
            number = index + 1,
            sum = sum + (number * operator),
            operator = 1,
            expression = "$expression+${index + 1}",
        )
        val c = solution(
            n = n,
            index = index + 1,
            number = index + 1,
            sum = sum + (number * operator),
            operator = -1,
            expression = "$expression-${index + 1}",
        )
        return a + b + c
    }
}

fun main() {
    val test = readln().toInt()
    val solution = `7490_2`()
    repeat(test) {
        val n = readln().toInt()
        solution.solution(
            n = n,
            index = 1,
            number = 1,
            sum = 0,
            operator = 1,
            expression = "1",
        ).forEach { println(it) }
        println()
    }
}

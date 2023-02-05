package boj.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun solution(kg: Int): Int {
    var kg = kg
    var bags = 0
    while (true) {
        if (kg % 5 == 0) {
            return (kg / 5) + bags
        } else if (kg < 0) {
            return -1
        }
        kg -= 3
        bags++
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val kg = br.readLine().toInt()
    println(solution(kg))
}

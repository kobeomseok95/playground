package programmers.level2

class Solution132265 {
    fun solution(topping: IntArray): Int {
        val count = topping
            .groupBy { it }
            .mapValues { it.value.size }
            .toMutableMap()
        val a = topping.toMutableSet()
        val b = mutableSetOf<Int>()
        var answer = 0
        for (i in topping) {
            count[i] = count[i]!! - 1
            if (count[i]!! == 0) {
                a.remove(i)
            }
            b.add(i)

            if (a.size == b.size) {
                answer += 1
            }
        }
        return answer
    }
}

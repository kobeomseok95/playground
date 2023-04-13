package programmers.level2

class Solution42578 {
    fun solution(clothes: Array<Array<String>>): Int =
        clothes.groupBy { it[1] }
            .values
            .fold(1) { acc, arrays ->
                acc * (arrays.size + 1)
            }
            .minus(1)
}

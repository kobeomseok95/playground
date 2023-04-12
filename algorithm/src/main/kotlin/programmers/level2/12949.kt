package programmers.level2

class Solution12949 {
    fun solution(
        arr1: Array<IntArray>,
        arr2: Array<IntArray>,
    ): Array<IntArray> {
        return Array(arr1.size) { i ->
            Array(arr2[0].size) { j ->
                var acc = 0
                for (k in 0 until arr1[0].size) {
                    acc += arr1[i][k] * arr2[k][j]
                }
                acc
            }.toIntArray()
        }
    }
}

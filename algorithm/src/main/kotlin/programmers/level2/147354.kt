package programmers.level2

class Solution147354 {
    fun solution(
        data: Array<IntArray>,
        col: Int,
        row_begin: Int,
        row_end: Int,
    ): Int {
        val col = col - 1
        val rowBegin = row_begin - 1
        val rowEnd = row_end - 1

        val sorted = data.sortedWith(compareBy( { it[col] }, { -it[0] }))
        val accumulators = mutableListOf<Int>()
        for (i in rowBegin..rowEnd) {
            sorted[i]
                .fold(0) { acc, x -> acc + (x % (i + 1)) }
                .apply(accumulators::add)
        }

        return accumulators.fold(0) { acc, a -> acc xor a }
    }
}

class Solution147354_2 {
    fun solution(
        data: Array<IntArray>,
        col: Int,
        row_begin: Int,
        row_end: Int,
    ): Int = data
        .sortedWith(compareBy( { it[col - 1] }, { -it.first() }))
        .let { sortedData ->
            (row_begin - 1 until row_end)
                .map { row ->
                    sortedData[row].indices.fold(0) { acc, i ->
                        acc + sortedData[row][i] % (row + 1)
                    }
                }.fold(0) { acc, i ->
                    acc xor i
                }
        }
}

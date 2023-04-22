package programmers.level2

class Solution178870 {
    fun solution(sequence: IntArray, k: Int): Array<Int> {
        val answer = Array(2) { Int.MAX_VALUE }
        val sequence = sequence.toList()
        var startIndex = 0
        var endIndex = 0
        var partialSum = sequence[0]
        var partialSumLength = Int.MAX_VALUE
        while(startIndex < sequence.size && endIndex < sequence.size) {
            if (partialSum < k) {
                if (endIndex + 1 < sequence.size) {
                    partialSum += sequence[endIndex + 1]
                }
                endIndex += 1
            } else if (partialSum > k) {
                partialSum -= sequence[startIndex]
                startIndex += 1
            } else {
                val length = endIndex - startIndex
                if (partialSumLength > length) {
                    partialSumLength = length
                    answer[0] = startIndex
                    answer[1] = endIndex
                }
                partialSum -= sequence[startIndex]
                startIndex += 1
            }
        }
        return answer
    }
}

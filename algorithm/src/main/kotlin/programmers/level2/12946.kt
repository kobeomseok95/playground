package programmers.level2

class Solution12946 {
    fun solution(n: Int): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        fun hanoi(diskCount: Int, start: Int, end: Int, via: Int) {
            if (diskCount == 1) {
                answer.add(intArrayOf(start, end))
                return
            }
            hanoi(diskCount - 1, start, via, end)
            answer.add(intArrayOf(start, end))
            hanoi(diskCount - 1, via, end, start)
        }

        hanoi(n, 1, 3, 2)
        return answer.toTypedArray()
    }
}

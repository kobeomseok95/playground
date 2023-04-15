package programmers.level2

class Solution131127 {
    fun solution(
        want: Array<String>,
        number: IntArray,
        discount: Array<String>,
    ): Int {
        var answer = 0
        val wantMap = mutableMapOf<String, Int>()
        discount.forEachIndexed { index, _ ->
            wantMap.initialWantMap(want, number)
            var count = 0
            for (i in index until discount.size) {
                val food = discount[i]
                if (wantMap[food] == null) {
                    break
                }
                if (wantMap[food] == 0) {
                    break
                }
                wantMap[food] = wantMap[food]!! - 1
                count += 1
            }
            if (count == 10) {
                answer += 1
            }
        }
        return answer
    }

    private fun MutableMap<String, Int>.initialWantMap(
        want: Array<String>,
        number: IntArray,
    ) {
        clear()
        repeat(want.size) {
            this[want[it]] = number[it]
        }
    }
}

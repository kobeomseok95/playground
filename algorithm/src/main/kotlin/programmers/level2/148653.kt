package programmers.level2

class Solution148653 {
    fun solution(storey: Int): Int {
        var answer: Int = 0
        var storey = storey
        while (storey > 0) {
            val onesPlace = storey % 10
            val tensPlace = (storey % 100) / 10

            if (onesPlace > 5) {
                answer += (10 - onesPlace)
                storey += 10
            } else if (onesPlace == 5) {
                answer += 5
                storey += if (tensPlace >= 5) 10 else 0
            } else {
                answer += onesPlace
            }

            storey /= 10
        }
        return answer
    }
}

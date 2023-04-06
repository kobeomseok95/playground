package programmers.level2

class Solution12953 {
    fun solution(arr: IntArray): Int {
        if (arr.size == 1) {
            return arr[0]
        }
        var answer = (arr[0] * arr[1]) / gcd(arr[0], arr[1])
        for (i in 2 until arr.size) {
            answer = (answer * arr[i]) / gcd(answer, arr[i])
        }

        return answer
    }

    private fun gcd(a: Int, b: Int): Int {
        val r = a % b
        if (r == 0) {
            return b
        }
        return gcd(b, r)
    }
}

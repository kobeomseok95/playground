package programmers.level2

class Solution12914 {
    fun solution(n: Int): Long {
        val arr = Array(n + 1) { 0L }
        arr[0] = 1
        arr[1] = 1
        if (n <= 1) {
            return arr[n]
        }

        for(i in 2..n) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567
        }
        return arr[n] % 1234567
    }
}

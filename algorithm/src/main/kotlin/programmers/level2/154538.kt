package programmers.level2

class Solution154538 {
    fun solution(
        x: Int,
        y: Int,
        n: Int,
    ): Int {
        val dp = Array(y + 1) { MAX }
            .apply { this[x] = 0 }

        for (i in x + 1..y) {
            var a = MAX
            var b = MAX
            var c = MAX

            if (i >= x + n && i - n >= x) {
                a = dp[i - n]
            }
            if (i % 2 == 0 && i / 2 >= x) {
                b = dp[i / 2]
            }
            if (i % 3 == 0 && i / 3 >= x) {
                c = dp[i / 3]
            }

            var min = Integer.min(a, b)
            min = Integer.min(min, c)
            dp[i] = min.takeUnless { it == MAX }?.inc() ?: MAX
        }
        return dp[y].takeUnless { it == MAX } ?: -1
    }

    companion object {
        private const val MAX = Integer.MAX_VALUE
    }
}

class Solution154538_2 {
    var answer = MAX

    fun solution(
        x: Int,
        y: Int,
        n: Int,
    ): Int {
        dfs(x, y, n)
        return answer.takeUnless { it == MAX } ?: -1
    }

    private fun dfs(
        x: Int,
        y: Int,
        n: Int,
        count: Int = 0,
    ) {
        if (x > y || count >= answer) {
            return
        } else if (x == y) {
            answer = Integer.min(answer, count)
            return
        }

        dfs(x + n, y, n, count + 1)
        dfs(x * 2 , y, n, count + 1)
        dfs(x * 3, y, n, count + 1)
    }

    companion object {
        private const val MAX = 20
    }
}

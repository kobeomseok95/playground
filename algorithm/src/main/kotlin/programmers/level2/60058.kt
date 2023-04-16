package programmers.level2

class Solution60058 {
    fun solution(p: String): String {
        return split(p)
    }

    private fun split(s: String): String {
        var u = ""
        var v = ""
        var check = 0
        var count = 0

        if (s.isEmpty()) return ""

        for (i in s) {
            if (i == '(') {
                check += 1
            } else {
                check -= 1
            }
            count += 1

            if (check == 0) {
                u = s.substring(0, count)
                v = s.substring(count, s.length)
                break
            }
        }

        if (u.isCorrect()) {
            return u + split(v)
        } else {
            var a = '(' + split(v) + ')'
            var b = ""
            u.substring(1, u.length - 1).forEach {
                if (it == '(') {
                    b += ')'
                } else {
                    b += '('
                }
            }
            return a + b
        }
    }

    private fun String.isCorrect(): Boolean {
        var count = 0
        for (i in this) {
            if (i == '(') {
                count += 1
            } else {
                count -= 1
            }

            if (count < 0) {
                return false
            }
        }
        return true
    }
}

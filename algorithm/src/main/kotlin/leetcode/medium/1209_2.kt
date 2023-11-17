package leetcode.medium

class `1209_2` {
    fun removeDuplicates(s: String, k: Int): String {
        var i = 0
        val count = IntArray(s.length) { 0 }
        val arr = s.toCharArray()

        for (j in s.indices) {
            arr[i] = arr[j]
            if (i > 0 && arr[i] == arr[i - 1]) {
                count[i] = count[i - 1] + 1
            } else {
                count[i] = 1
            }

            if (count[i] >= k) {
                i -= k
            }
            i += 1
        }

        return arr.joinToString("").substring(0, i)
    }
}

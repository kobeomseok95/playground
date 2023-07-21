package leetcode.medium

class `17` {
    fun letterCombinations(digits: String): List<String> = arrayListOf<String>()
        .apply {
            if (digits.isEmpty()) {
                return emptyList()
            }
            dfs(
                temp = "",
                result = this,
                digits = digits,
            )
        }

    private fun dfs(
        temp: String,
        result: ArrayList<String>,
        digits: String,
        start: Int = 0,
    ) {
        if (digits.length == temp.length) {
            result.add(temp)
        }

        IntRange(start, digits.length - 1).forEach { i ->
            val currentDigit = digits.toCharArray()[i]
            digitCharactersMap[currentDigit.toString().toInt()]!!.forEach { letter ->
                dfs(
                    temp = temp + letter,
                    result = result,
                    digits = digits,
                    start = i + 1,
                )
            }
        }
    }

    companion object {
        private val digitCharactersMap = mapOf(
            2 to "abc",
            3 to "def",
            4 to "ghi",
            5 to "jkl",
            6 to "mno",
            7 to "pqrs",
            8 to "tuv",
            9 to "wxyz"
        )
    }
}

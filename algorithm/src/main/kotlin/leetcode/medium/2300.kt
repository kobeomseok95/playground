package leetcode.medium

class `2300` {
    fun successfulPairs(
        spells: IntArray,
        potions: IntArray,
        success: Long,
    ): IntArray {
        val sortedPotions = potions.sorted()
        val size = sortedPotions.size
        return spells.map { spell ->
            val index = searchIndex(spell, sortedPotions, success)
            size - index
        }.toIntArray()
    }

    private fun searchIndex(
        spell: Int,
        sortedPotions: List<Int>,
        success: Long,
    ): Int {
        var left = 0
        var right = sortedPotions.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            val pairResult = sortedPotions[mid].toLong() * spell.toLong()
            if (pairResult < success) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return left
    }
}

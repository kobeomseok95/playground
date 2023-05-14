package programmers.level2

data class Card(
    val value: Int,
    val index: Int,
)

class Solution131130 {
    fun solution(cards: IntArray): Int {
        return makeGroups(cards)
            .map { it.size }
            .sortedDescending()
            .let {
                if (it.size < 2) {
                    it[0] * 0
                } else {
                    it[0] * it[1]
                }
            }
    }

    private fun makeGroups(cards: IntArray): List<List<Int>> {
        val convertedCards = convertCards(cards)
        var list = mutableListOf<List<Int>>()

        var searchIndex = 1
        val group = mutableListOf<Int>()
        while (convertedCards.isNotEmpty()) {
            val card = convertedCards.find { it.index == searchIndex }
            if (card == null) {
                list.add(group.toList())
                searchIndex = nextSearchIndex(convertedCards)
                group.clear()
            } else {
                convertedCards.remove(card)
                group.add(card.value)
                searchIndex = card.value
            }
        }
        if (group.size > 0) {
            list.add(group)
        }
        return list.toList()
    }

    private fun convertCards(cards: IntArray): MutableList<Card> =
        cards.mapIndexed { index, value ->
            Card(
                value = value,
                index = index + 1,
            )
        }.toMutableList()

    private fun nextSearchIndex(convertedCards: List<Card>): Int =
        if (convertedCards.isEmpty()) {
            -1
        } else {
            convertedCards[0].index
        }
}

class Solution131130_2 {
    fun solution(cards: IntArray): Int {
        var groupId = 0
        val grouping = IntArray(cards.size) { -1 }
        cards.forEachIndexed { index, _ ->
            var target = index
            while (grouping[target] == -1) {
                grouping[target] = groupId
                target = cards[target] - 1
            }
            groupId += 1
        }

        return grouping.groupBy { it }
            .map { it.value.size }
            .sortedDescending()
            .takeIf { it.size >= 2 }
            ?.subList(0, 2)
            ?.fold(1) { a, b -> a * b }
            ?: 0
    }
}

fun main() {
    val s = Solution131130_2()
    s.solution(
//        cards = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 1),
        cards = intArrayOf(8, 6, 3, 7, 2, 5, 1, 4),
    ).apply(::println)
}

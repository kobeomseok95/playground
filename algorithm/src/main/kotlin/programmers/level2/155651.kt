package programmers.level2


data class Book(
    val startTime: Int,
    val endTime: Int,
) : Comparable<Book> {
    override fun compareTo(other: Book): Int {
        if (this.startTime == other.startTime) {
            return this.endTime - other.endTime
        }
        return this.startTime - other.startTime
    }
}

class Solution155651 {
    fun solution(bookTimes: Array<Array<String>>): Int {
        val books = bookTimes.map {
            Book(
                startTime = toMinutes(it[0]),
                endTime = toMinutes(it[1]) + 10,
            )
        }.toMutableList()
        books.sort()

        val endTimes = mutableListOf<Int>()
        for (book in books) {
            var isCheckedInUsedRoom = false
            endTimes.sort()
            for (i in 0 until endTimes.size) {
                if (book.startTime >= endTimes[i]) {
                    endTimes[i] = book.endTime
                    isCheckedInUsedRoom = true
                    break
                }
            }
            if (isCheckedInUsedRoom.not()) {
                endTimes.add(book.endTime)
            }
        }
        return endTimes.size
    }

    private fun toMinutes(time: String): Int =
        time.split(":").foldIndexed(0) { idx, sum, element ->
            if (idx == 0) {
                sum + element.toInt() * 60
            } else {
                sum + element.toInt()
            }
        }
}

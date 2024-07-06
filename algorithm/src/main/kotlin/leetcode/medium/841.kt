package leetcode.medium


class `841` {
    fun canVisitAllRooms(
        rooms: List<List<Int>>,
        key: Int = 0,
        visits: MutableSet<Int> = mutableSetOf(0),
    ): Boolean {
        val keys = rooms[key]
        keys.forEach { key ->
            if (!visits.any { it == key }) {
                visits.add(key)
                canVisitAllRooms(rooms, key, visits)
            }
        }
        return visits.size == rooms.size
    }
}

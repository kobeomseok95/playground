package programmers.level2

class `176962` {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val sortedPlans = plans.map { plan ->
            val (startHour, startMinute) = plan[1].split(":")
            val startIntTime = startHour.toInt() * 60 + startMinute.toInt()
            Plan(
                subject = plan[0],
                startTime = startIntTime,
                duration = plan[2].toInt(),
            )
        }.sortedBy{ it.startTime }

        sortedPlans.indices.forEach { i ->
            (i + 1 until sortedPlans.size).forEach { j ->
                if (sortedPlans[i].endTime > sortedPlans[j].startTime) {
                    sortedPlans[i].duration += sortedPlans[j].duration
                } else {
                    return@forEach
                }
            }
        }

        return sortedPlans.sortedBy { it.endTime }.map { it.subject }.toTypedArray()
    }

    data class Plan(
        val subject: String,
        var startTime: Int,
        var duration: Int,
    ) {
        val endTime: Int
            get() = startTime + duration
    }
}

fun main() {
    `176962`().solution(
        plans = arrayOf(
            arrayOf("korean", "11:40", "30"),
            arrayOf("english", "12:10", "20"),
            arrayOf("math", "12:30", "40"),
        )
    ).onEach(::println) // korean, english, math
    println()
    `176962`().solution(
        plans = arrayOf(
            arrayOf("science", "12:40", "50"),
            arrayOf("music", "12:20", "40"),
            arrayOf("history", "14:00", "30"),
            arrayOf("computer", "12:30", "100"),
        )
    ).onEach(::println)
    println()
    `176962`().solution(
        plans = arrayOf(
            arrayOf("aaa", "12:00", "20"),
            arrayOf("bbb", "12:10", "30"),
            arrayOf("ccc", "12:40", "10"),
        )
    ).onEach(::println)
    println()
    `176962`().solution(
        plans = arrayOf(
            arrayOf("1", "00:00", "30"),
            arrayOf("2", "00:10", "40"),
            arrayOf("3", "00:20", "10"),
            arrayOf("4", "00:25", "10"),
            arrayOf("5", "01:10", "10"),
        )
    ).onEach(::println)
}








































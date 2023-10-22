package programmers.level2

import java.util.*

class `176962` {
    private lateinit var todo: List<Plan>
    private val paused = Stack<Plan>()
    private val answer = mutableListOf<String>()

    fun solution(plans: Array<Array<String>>): Array<String> {
        setTodoPlans(plans)

        todo.dropLast(1).forEachIndexed { i, plan ->
            val nextStartTime = todo[i + 1].startTime

            if (plan.endTime <= nextStartTime) {
                answer.add(plan.subject)
                var remainTime = nextStartTime - plan.endTime

                while (remainTime > 0 && paused.isNotEmpty()) {
                    if (paused.peek().duration <= remainTime) {
                        remainTime -= paused.peek().duration
                        answer.add(paused.pop().subject)
                    } else {
                        val pop = paused.pop()
                        paused.push(
                            pop.copy(duration = pop.duration - remainTime)
                        )
                        remainTime = 0
                    }
                }
            } else {
                paused.push(
                    plan.copy(
                        duration = plan.endTime - nextStartTime
                    )
                )
            }
        }
        answer.add(todo.last().subject)

        while (paused.isNotEmpty()) {
            answer.add(paused.pop().subject)
        }

        return answer.toTypedArray()
    }

    private fun setTodoPlans(plans: Array<Array<String>>) {
        todo = plans.map { plan ->
            val (startHour, startMinute) = plan[1].split(":")
            val startIntTime = startHour.toInt() * 60 + startMinute.toInt()
            Plan(
                subject = plan[0],
                startTime = startIntTime,
                duration = plan[2].toInt(),
            )
        }.sortedBy { it.startTime }
    }

    data class Plan(
        val subject: String,
        val startTime: Int,
        val duration: Int,
    ) {
        val endTime: Int
            get() = startTime + duration
    }
}

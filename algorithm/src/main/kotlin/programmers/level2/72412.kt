package programmers.level2

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val languageMap = mapOf<String, MutableList<Int>>(
            "cpp" to mutableListOf(),
            "java" to mutableListOf(),
            "python" to mutableListOf(),
        )
        val jobGroupMap = mapOf<String, MutableList<Int>>(
            "backend" to mutableListOf(),
            "frontend" to mutableListOf(),
        )
        val careerHistoryMap = mapOf<String, MutableList<Int>>(
            "junior" to mutableListOf(),
            "senior" to mutableListOf(),
        )
        val soulFoodMap = mapOf<String, MutableList<Int>>(
            "chicken" to mutableListOf(),
            "pizza" to mutableListOf(),
        )
        val scores = mutableListOf<Int>()
        info.forEachIndexed { index, applicantInfo ->
            val infoSplit = applicantInfo.split(" ")
            languageMap[infoSplit[0]]?.add(index)
            jobGroupMap[infoSplit[1]]?.add(index)
            careerHistoryMap[infoSplit[2]]?.add(index)
            soulFoodMap[infoSplit[3]]?.add(index)
            scores.add(infoSplit[4].toInt())
        }

        query.forEach {
            val (language, jobGroup, careerHistory, soulFoodAndScore) = it.split(" and ")
            val (soulFood, score) = soulFoodAndScore.split(" ")

        }






        return intArrayOf()
    }
}

















fun main() {
    val a = Solution()
    a.solution(
        info = arrayOf(
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        ),
        query = arrayOf(
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        ),
    )
}
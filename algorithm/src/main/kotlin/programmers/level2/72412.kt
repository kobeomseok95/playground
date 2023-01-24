package programmers.level2

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val applicantInfoMap = initializeApplicantInfoMap()
        applicantInfoMap.setApplicantInfoAndSort(info)
        for (q in query) {
            val querySplit = q.split(" and ", " ")
            val queryKey = StringBuilder()
                .append(querySplit[0])
                .append(querySplit[1])
                .append(querySplit[2])
                .append(querySplit[3])
                .toString()
            val queryScore = querySplit[4].toInt()
            val count = applicantInfoMap.findByBinarySearch(queryKey, queryScore)
            answer.add(count)
        }
        return answer.toIntArray()
    }

    private fun initializeApplicantInfoMap(): Map<String, MutableList<Int>> {
        val applicantInfoMap = mutableMapOf<String, MutableList<Int>>()
        for (language in listOf("cpp", "java", "python", "-")) {
            for (position in listOf("backend", "frontend", "-")) {
                for (career in listOf("junior", "senior", "-")) {
                    for (food in listOf("chicken", "pizza", "-")) {
                        val key = language + position + career + food
                        applicantInfoMap[key] = mutableListOf()
                    }
                }
            }
        }
        return applicantInfoMap
    }

    private fun Map<String, MutableList<Int>>.setApplicantInfoAndSort(
        info: Array<String>,
    ) {
        for (infoStr in info) {
            val splitInfo = infoStr.split(" ")
            for (language in listOf(splitInfo[0], "-")) {
                for (position in listOf(splitInfo[1], "-")) {
                    for (career in listOf(splitInfo[2], "-")) {
                        for (food in listOf(splitInfo[3], "-")) {
                            val key = StringBuilder()
                                .append(language)
                                .append(position)
                                .append(career)
                                .append(food)
                                .toString()
                            this[key]?.add(splitInfo[4].toInt())
                        }
                    }
                }
            }
        }
        for (key in this.keys) {
            this[key]?.sort()
        }
    }

    private fun Map<String, MutableList<Int>>.findByBinarySearch(
        queryKey: String,
        queryScore: Int,
    ): Int {
        val findScores = this[queryKey] ?: listOf()
        val size = findScores.size
        var temp = size
        var low = 0
        var high = size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (queryScore <= findScores[mid]) {
                temp = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return size - temp
    }
}

fun main() {
    val a = Solution()
    val answers = a.solution(
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
    for (answer in answers) {
        println(answer)
    }
}
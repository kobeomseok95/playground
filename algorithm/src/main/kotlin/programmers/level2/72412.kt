package programmers.level2

private class Solution72412 {
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

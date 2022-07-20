package chapter_4.`object`

object CaseInsensitiveFileComparator : Comparator<String>{
    override fun compare(o1: String?, o2: String?): Int {
        if (o1 == null || o2 == null) {
            throw IllegalArgumentException("")
        }
        return o1.compareTo(o2, ignoreCase = true)
    }
}
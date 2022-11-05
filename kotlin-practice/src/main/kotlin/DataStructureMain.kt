fun main() {
    val s1 = setOf(1,2,3,4,5)
    val s2 = setOf(3,4,5)
    val empty = emptySet<Int>()

    println(s2.intersect(s1))
}

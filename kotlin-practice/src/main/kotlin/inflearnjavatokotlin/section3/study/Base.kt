package inflearnjavatokotlin.section3.study

open class Base(
//    open val number: Int
    private val number: Int = 100
) {
    init {
        println("Base number = $number")
    }
}
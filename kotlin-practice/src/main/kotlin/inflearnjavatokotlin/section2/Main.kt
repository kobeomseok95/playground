package inflearnjavatokotlin.section2

fun main() {
    val arr = arrayOf("A", "B")
    printAll(*arr)
    printAll("A", "B")
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}
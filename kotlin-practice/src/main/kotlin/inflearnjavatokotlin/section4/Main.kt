package inflearnjavatokotlin.section4

fun main() {
    val fruits = createNestedFruits()
    println(fruits.flatten())
}


private fun createNestedFruits() = listOf(
    listOf(
        Fruit(1L, "사과", 2_000L, 5_000L),
        Fruit(2L, "사과", 5_000L, 5_000L),
        Fruit(3L, "바나나", 1_000L, 6_000L),
    ),
    listOf(
        Fruit(4L, "포도", 3_000L, 3_000L),
        Fruit(5L, "포도", 4_000L, 7_000L),
    ),
    listOf(
        Fruit(6L, "바나나", 2_000L, 2_000L),
        Fruit(7L, "사과", 2_000L, 8_000L),
    )
)

private fun createFruits() = listOf(
    Fruit(1L, "사과", 2_000L, 3_000L),
    Fruit(2L, "사과", 1_000L, 5_000L),
    Fruit(3L, "바나나", 1_000L, 6_000L),
    Fruit(4L, "포도", 3_000L, 7_000L),
    Fruit(5L, "포도", 4_000L, 7_000L),
    Fruit(6L, "바나나", 2_000L, 6_000L),
    Fruit(7L, "사과", 2_000L, 8_000L),
)

private fun lambdaSampleCode(fruits: List<Fruit>) {
    val lambdaOne = { fruit: Fruit -> fruit.name == "사과" }
    val lambdaTwo = { fruit: Fruit -> fruit.name == "사과" }
    println(lambdaOne == lambdaTwo)
    println(lambdaOne === lambdaTwo)
    println("lambdaOne = ${lambdaOne}")
    println("lambdaTwo = ${lambdaTwo}")

    val filterFruits = filterFruits(fruits) {
        println(it)
        println(it.name)
        it.name == "사과"
    }
    for (fruit in filterFruits) {
        println(fruit)
    }
}

private fun filterFruits(
    fruits: List<Fruit>,
    nameFilter: (Fruit) -> Boolean,
): List<Fruit> {
    return fruits.filter(nameFilter)
}

inline fun Int.add(other: Int) = this + other

fun String.lastChar(): Char {
    return this[this.length - 1]
}

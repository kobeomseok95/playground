package inflearnjavatokotlin.section5

class Person(
    val name: String,
    val age: Int,
) {
    operator fun component1() = this.name

    operator fun component2() = this.age
}

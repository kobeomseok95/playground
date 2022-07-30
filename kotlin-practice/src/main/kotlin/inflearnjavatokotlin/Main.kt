package inflearnjavatokotlin

fun main() {
    val m1 = Money(1_000L)
    val m2 = Money(2_000L)
    println("(m1 + m2) == (m1.plus(m2)) => ${(m1 + m2) == (m1.plus(m2))}")
}

fun fun1(): Boolean {
    println("fun1()")
    return true
}

fun fun2(): Boolean {
    println("fun2()")
    return true
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
    }
}
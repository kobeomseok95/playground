package inflearnjavatokotlin.section1

fun main() {
    val m1 = Money(200)
    val m2 = Money(100)
    if (m1 > m2) {
        println("m1이 더 큼")
    }
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
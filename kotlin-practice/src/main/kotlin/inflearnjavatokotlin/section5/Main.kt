package inflearnjavatokotlin.section5

fun main() {

}

fun printPerson(person: Person?) {

}

fun getNumberIfEvenOrNullTakeIf(number: Int) =
    number.takeIf { it % 2 == 0 }

fun getNumberIfEvenOrNullTakeUnless(number: Int) =
    number.takeUnless { it % 2 != 0 }
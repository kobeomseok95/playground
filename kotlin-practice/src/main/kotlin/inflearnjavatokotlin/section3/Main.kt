package inflearnjavatokotlin.section3

import inflearnjavatokotlin.section3.study.DerivedSampleClass

fun main() {
    val clazz = DerivedSampleClass("sample", 12)
    clazz.printProtectedProperty()
}

fun handleHyundaiCar(hyundaiCar: HyundaiCar) {
    when (hyundaiCar) {
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}

fun handleCountry(country: Country) = when (country) {
    Country.KOREA -> Country.KOREA
    Country.AMERICA -> Country.AMERICA
    Country.FRANCE -> Country.FRANCE
}


enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US"),
    FRANCE("FR"),
    ;
}

data class PersonDto(
    val name: String,
    val age: Int,
)

private fun moveSomething(movable: Movable) {
    movable.fly()
    movable.move()
}

interface Movable {
    fun fly()
    fun move()
}

object Singleton {
    var a: Int = 0
}

class Person private constructor(
    var name: String,
    val age: Int,
) {

    companion object Factory: Log {
        private const val MIN_AGE = 1

        fun newBaby(name: String): Person {
            log()
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스 동행 객체")
        }
    }
}

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base class")
        println(number)
    }
}

class Derived (
    override val number: Int,
): Base(number) {
    init {
        println("Derived Class")
    }
}

//class Person (
//    name: String,
//    var age: Int = 1,
//) {
//
//    var name = name
//        set(value) {
//            field = value.toUpperCase()
//        }
//
//    init {
//        if (age <= 0) {
//            throw IllegalArgumentException("1살 이상이어야 합니다.")
//        }
//    }
//
//    val isAdult: Boolean
//        get() = this.age >= 20
//}
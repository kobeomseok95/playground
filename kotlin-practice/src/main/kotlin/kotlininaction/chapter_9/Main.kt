package kotlininaction.chapter_9

import kotlin.reflect.KClass

fun main() {
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultPositiveIntValidator)
    println(Validators[String::class].validate(""))
    println(Validators[Int::class].validate(-1))
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(
        kClass: KClass<T>,
        fieldValidator: FieldValidator<T>
    ) {
        validators[kClass] = fieldValidator
    }

    operator fun <T: Any> get(kClass: KClass<T>) =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("없어요.")
}

interface FieldValidator<in T> {
    fun validate(t: T): Boolean
}

object DefaultStringValidator: FieldValidator<String> {
    override fun validate(t: String) = t.isNotBlank()
}

object DefaultPositiveIntValidator: FieldValidator<Int> {
    override fun validate(t: Int) = t >= 0
}

fun <T> copyData(
    source: MutableList<T>,
    destination: MutableList<in T>
) {
    for (item in source) {
        destination.add(item)
    }
}

interface Producer<out T> {
    fun produce() : T
}

sealed class Animal {
    fun feed() {
        println("먹이를 먹는다.")
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("cleanLitter()")
    }
}

class Herd<out T: Animal> {
    val size: Int
        get() = 4

    operator fun get(i: Int): T {
        return this[i]
    }
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

fun takeCareOfCats(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
        feedAll(cats)
    }
}

interface OutList<out T> {
    fun get(): T
}

interface InList<in T> {
    fun add(t: T)
}

interface Comparator<in T> {
    fun compare(t1: T, t2: T)
}

interface Function1<in P, out R> {
    operator fun invoke(p: P): R
}
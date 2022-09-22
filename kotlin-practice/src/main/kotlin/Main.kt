import kotlin.reflect.KProperty

fun main() {

}

data class Rectangle<in T>(
    val width: @UnsafeVariance T,
    val height: @UnsafeVariance T,
)

interface BaseA {
    fun printA()
    fun printAA()
}

class BaseAImplA(
    private val a: Int,
) : BaseA {
    override fun printA() {
        println("a = $a")
    }

    override fun printAA() {
        println("aa = $a")
    }
}

class BaseAImplB(
    private val ab: Int,
) : BaseA {
    override fun printA() {
        println("ab = $ab")
    }

    override fun printAA() {
        println("aa = $ab")
    }
}

interface BaseB {
    fun printB()
}

class BaseBImpl(
    private val b: Int,
) : BaseB {
    override fun printB() {
        println("b = $b")
    }
}

class Derived(
    a: BaseA,
    b: BaseB,
) : BaseA by a, BaseB by b

class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "123"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println(1231)
    }
}

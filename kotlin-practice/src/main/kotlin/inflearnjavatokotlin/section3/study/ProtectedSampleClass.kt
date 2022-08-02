package inflearnjavatokotlin.section3.study

open class ProtectedSampleClass(
    protected val name: String,
    protected val code: Int,
) {
}

class DerivedSampleClass(
    private val derivedName: String,
    private val derivedCode: Int,
): ProtectedSampleClass(derivedName, derivedCode) {

    fun printProtectedProperty() {
        println("super.name = " + super.name)
        println("super.code = " + super.code)
    }
}
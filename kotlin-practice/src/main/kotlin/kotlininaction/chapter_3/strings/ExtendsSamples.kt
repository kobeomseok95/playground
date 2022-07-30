package kotlininaction.chapter_3.strings


fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
) = joinToString(separator, prefix, postfix)

// 수신 객체 타입 = String
// 수신 객체 = this
// 확장 함수 = lastChar()
fun String.lastChar(): Char = get(length - 1)
fun String.isOddLength() = length % 2 == 0

// 확장 프로퍼티, val은 밸류이므로 getter만 정의
val String.lastChar: Char
    get() = get(length - 1)

// 확장 프로퍼티, var는 변수라서 getter, setter 정의
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }

fun listPrint(args: Array<String>) {
    val list = listOf("args = ", *args)
    println(list)
}

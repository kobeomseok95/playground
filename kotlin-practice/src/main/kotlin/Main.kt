fun max(a: Int, b: Int) = if (a > b) a else b // 타입 추론

fun getMessage(number: Int): String {   // val 참조 자체는 불변, 그 참조가 가리키는 객체 내부의 값은 변경 가능
    val message: String
    if (number > 10) {
        message = "10이 넘어감"
    } else {
        message = "10 이하"
    }
    return message
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE -> "Richard"
        Color.GREEN, Color.YELLOW -> "Grave"
        Color.BLUE -> "Battle"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        else -> throw Exception("Dirty Color")
    }

fun main(args: Array<String>) {
    println(mix(Color.BLUE, Color.RED))
}

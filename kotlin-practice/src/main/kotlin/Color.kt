enum class Color (
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(2550, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    ORANGE(10, 10, 10),
    YELLOW(20, 20, 20)
    ;

    fun rgb() = (r * 256 + g) * 256 + b
}
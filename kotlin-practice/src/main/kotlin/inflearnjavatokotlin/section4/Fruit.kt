package inflearnjavatokotlin.section4

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    val isSamePrice
        get() = factoryPrice == currentPrice
}

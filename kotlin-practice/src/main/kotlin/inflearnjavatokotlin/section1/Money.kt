package inflearnjavatokotlin.section1

data class Money(
    val amount: Long,
) {
    operator fun plus(other: Money) = Money(this.amount + other.amount)
}

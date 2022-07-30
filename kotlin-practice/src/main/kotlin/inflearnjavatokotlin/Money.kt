package inflearnjavatokotlin

data class Money(
    val amount: Long,
) {
    operator fun plus(other: Money) = Money(this.amount + other.amount)
}

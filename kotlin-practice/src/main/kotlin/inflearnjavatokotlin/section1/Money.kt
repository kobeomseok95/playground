package inflearnjavatokotlin.section1

data class Money(
    val amount: Int,
): Comparable<Money> {
    operator fun plus(other: Money) = Money(this.amount + other.amount)

    override fun compareTo(other: Money): Int {
        return this.amount - other.amount
    }
}

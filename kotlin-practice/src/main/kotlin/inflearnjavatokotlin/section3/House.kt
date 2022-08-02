package inflearnjavatokotlin.section3

class House(
    private val address: String,
    private val livingRoom: LivingRoom,
) {
    inner class LivingRoom (
        private var area: Double,
    ) {
        val address: String
            get() = this@House.address
    }
}
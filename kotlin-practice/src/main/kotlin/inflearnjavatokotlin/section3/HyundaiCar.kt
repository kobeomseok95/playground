package inflearnjavatokotlin.section3

sealed class HyundaiCar(
    val name: String,
    val price: Long,
)

class Avante : HyundaiCar("아반떼", 2_000L)

class Sonata : HyundaiCar("소나타", 2_000L)

class Grandeur: HyundaiCar("그랜저", 3_000L)
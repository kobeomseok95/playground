package generic

interface Wearable

abstract class Clothing : Wearable {
    abstract val name: String
}

interface Accessory : Wearable

sealed class Shoes : Accessory {
    data class Boots(val name: String) : Shoes()
}

sealed class Top(
    override val name: String,
) : Clothing() {
    data class TShirt(override val name: String) : Top(name)
    data class Shirt(override val name: String) : Top(name)
}

sealed class Bottom(
    override val name: String,
) : Clothing() {
    data class Jeans(override val name: String) : Bottom(name)
    data class ChinoPants(override val name: String) : Bottom(name)
}

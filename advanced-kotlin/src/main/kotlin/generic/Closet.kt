package generic

class Closet<T : Clothing> {
    val clothes: MutableList<@UnsafeVariance T> = mutableListOf()

    fun add(clothing: @UnsafeVariance T) {
        clothes.add(clothing)
    }

    fun addClosetsClothes(closet: Closet<@UnsafeVariance T>) {
        clothes.addAll(closet.clothes)
    }

    fun remove(clothing: @UnsafeVariance T) {
        clothes.remove(clothing)
    }

    fun removeClosetsClothes(closet: Closet<@UnsafeVariance T>) {
        clothes.removeAll(closet.clothes)
    }

    fun getFirst(): T? {
        return this.clothes.firstOrNull()
    }
}

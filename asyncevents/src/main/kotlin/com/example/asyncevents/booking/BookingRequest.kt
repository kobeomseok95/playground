package com.example.asyncevents.booking

data class BookingRequest(
    val productId: Long,
    val items: List<Item>,
) {
    data class Item(
        val productItemId: Long,
        val quantity: Int,
    )
}

package com.mongo.data.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
class Product(
    @Id
    var id: String? = null,
    val content: Content?,
    val attribute: Attribute?,
    val comments: InspectionComments?,
) {
    fun addComments(request: List<CommentRequest>) {
        comments?.addAll(request)
            ?: InspectionComments.create(request)
    }
}

data class Content(
    val title: String,
    val subTitle: String,
    val mainText: String,
)

data class Attribute(
    val type: String,
    val amount: Int,
)

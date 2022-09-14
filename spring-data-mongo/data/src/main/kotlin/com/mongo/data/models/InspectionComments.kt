package com.mongo.data.models

import java.util.*

data class InspectionComments(
    val comments: TreeMap<String, Any>
) {
    fun addAll(request: List<CommentRequest>) {
        validateFieldNames(request)
    }

    private fun validateFieldNames(request: List<CommentRequest>) {
        request.forEach { FieldEnum.isExistByRequestFieldOrThrow(it.fieldName) }
    }

    companion object {
        fun create(request: List<CommentRequest>) {

        }
    }
}

data class Comment(
    val value: String? = null,
    val resolved: Boolean? = false,
)

enum class FieldEnum(
    val fieldName: String,
) {
    CONTENT(Fields.CONTENT),
    TITLE(Fields.TITLE),
    SUB_TITLE(Fields.SUB_TITLE),
    MAIN_TEXT(Fields.MAIN_TEXT),
    ATTRIBUTE(Fields.ATTRIBUTE),
    TYPE(Fields.TYPE),
    AMOUNT(Fields.AMOUNT),
    ;

    companion object {
        private val fieldNameMap = FieldEnum.values()
            .associateBy { it.fieldName }
        val fieldHierarchyMap = mapOf(
            Fields.CONTENT to mapOf(
                Fields.TITLE to Comment(),
                Fields.SUB_TITLE to Comment(),
                Fields.MAIN_TEXT to Comment(),
            ),
            Fields.ATTRIBUTE to mapOf(
                Fields.TYPE to Comment(),
                Fields.AMOUNT to Comment(),
            )
        )

        fun isExistByRequestFieldOrThrow(field: String) {
            if (!FieldEnum.fieldNameMap.containsKey(field)) {
                throw IllegalArgumentException("필드가 존재하지 않습니다.")
            }
        }
    }
}


class Fields {
    companion object {
        const val CONTENT = "content"
        const val TITLE = "title"
        const val SUB_TITLE = "subTitle"
        const val MAIN_TEXT = "mainText"

        const val ATTRIBUTE = "attribute"
        const val TYPE = "type"
        const val AMOUNT = "amount"
    }
}

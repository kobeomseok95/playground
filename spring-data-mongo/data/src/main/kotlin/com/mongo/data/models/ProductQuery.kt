package com.mongo.data.models

import java.time.LocalDate

data class ProductQuery(
    val title: String?,
    val createdDateStart: LocalDate?,
    val createdDateEnd: LocalDate?,
)

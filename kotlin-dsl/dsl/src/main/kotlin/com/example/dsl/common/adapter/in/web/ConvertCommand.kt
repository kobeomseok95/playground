package com.example.dsl.common.adapter.`in`.web

interface ConvertCommand<T> {
    fun toCommand(): T
}
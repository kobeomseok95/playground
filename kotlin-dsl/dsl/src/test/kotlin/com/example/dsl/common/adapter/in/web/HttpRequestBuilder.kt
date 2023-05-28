package com.example.dsl.common.adapter.`in`.web

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod

class HttpRequestBuilder(
    var method: HttpMethod = HttpMethod.GET,
    var path: String = "/",
    val headers: HttpHeaders = HttpHeaders(),
    var body: String? = null,
) {
    fun header(name: String, value: String) {
        headers[name] = value
    }
}

class HttpTestDSL {
    val requests: MutableList<HttpRequestBuilder> = mutableListOf()

    fun request(init: HttpRequestBuilder.() -> Unit) {
        val builder = HttpRequestBuilder().apply { init() }
        requests.add(builder)
    }
}

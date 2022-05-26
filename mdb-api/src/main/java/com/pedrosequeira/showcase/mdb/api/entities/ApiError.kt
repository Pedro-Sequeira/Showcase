package com.pedrosequeira.showcase.mdb.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiError(
    @Json(name = "status_message")
    val statusMessage: String? = null,
    @Json(name = "success")
    val success: Boolean? = null,
    @Json(name = "status_code")
    val statusCode: Int? = null
)

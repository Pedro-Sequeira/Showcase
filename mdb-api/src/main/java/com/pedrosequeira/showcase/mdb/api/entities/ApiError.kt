package com.pedrosequeira.showcase.mdb.api.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    @SerialName("status_message")
    val statusMessage: String? = null,
    @SerialName("success")
    val success: Boolean? = null,
    @SerialName("status_code")
    val statusCode: Int? = null
)

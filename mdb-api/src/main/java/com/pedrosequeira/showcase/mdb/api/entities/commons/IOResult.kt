package com.pedrosequeira.showcase.mdb.api.entities.commons

sealed class IOResult<out T> {

    data class Success<T>(val data: T) : IOResult<T>()

    data class NetworkError(
        val statusMessage: String,
        val success: Boolean,
        val statusCode: Int
    )
}

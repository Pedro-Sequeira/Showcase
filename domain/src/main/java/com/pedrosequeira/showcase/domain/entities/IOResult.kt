package com.pedrosequeira.domain.entities

sealed class IOResult<out T> {

    data class Success<T>(val data: T) : IOResult<T>()

    sealed class Error : IOResult<Nothing>() {

        data class NetworkError(
            val statusMessage: String,
            val success: Boolean,
            val statusCode: Int
        ) : Error()

        object NetworkUnavailable : Error()
    }
}

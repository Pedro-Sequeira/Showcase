package com.pedrosequeira.showcase.domain.commons.entities

sealed class IOResult<out T> {

    data class Success<T>(val data: T) : IOResult<T>()

    sealed class Error : IOResult<Nothing>() {

        data class NetworkError(
            val statusMessage: String = "Something went wrong.",
            val success: Boolean = false,
            val statusCode: Int = 500
        ) : Error()

        object NetworkUnavailable : Error()
    }
}

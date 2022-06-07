package com.pedrosequeira.showcase.core

import com.pedrosequeira.showcase.core.providers.StringProvider
import com.pedrosequeira.showcase.domain.commons.entities.DomainException
import com.pedrosequeira.showcase.domain.commons.entities.Error
import javax.inject.Inject

class ErrorMapper @Inject constructor(
    private val stringProvider: StringProvider
) {

    fun mapToMessage(error: Throwable): String {
        if (error is DomainException) return error.toMessage()

        return stringProvider.getString(R.string.error_unknown_message)
    }

    private fun DomainException.toMessage(): String {
        return when (error) {
            is Error.ApiError -> (error as Error.ApiError).toMessage()

            is Error.NotFound,
            is Error.Unknown -> stringProvider.getString(R.string.error_unknown_message)
        }
    }

    private fun Error.ApiError.toMessage(): String {
        return stringProvider.getString(
            when (this) {
                is Error.ApiError.NetworkError -> R.string.error_api_network_message
                is Error.ApiError.ServiceUnavailable -> R.string.error_api_server_message

                is Error.ApiError.ClientError,
                is Error.ApiError.Unknown -> R.string.error_api_unknown_message
            }
        )
    }
}

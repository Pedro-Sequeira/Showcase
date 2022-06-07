package com.pedrosequeira.showcase.data.mappers

import com.pedrosequeira.showcase.domain.commons.entities.Error as DomainError
import com.pedrosequeira.showcase.data.commons.entities.Error as DataError
import javax.inject.Inject

internal class ErrorMapper @Inject constructor() {

    fun mapToDomainError(dataError: DataError): DomainError {
        return when (dataError) {
            is DataError.ApiError -> dataError.toDomainApiError()
            is DataError.NotFound -> DomainError.NotFound(dataError.message)
            is DataError.Unknown -> DomainError.Unknown(dataError.message)
        }
    }

    private fun DataError.ApiError.toDomainApiError(): DomainError.ApiError {
        return when (this) {
            is DataError.ApiError.ClientError -> DomainError.ApiError.ClientError(message)
            is DataError.ApiError.NetworkError -> DomainError.ApiError.NetworkError(message)
            is DataError.ApiError.ServiceUnavailable -> DomainError.ApiError.ServiceUnavailable
            is DataError.ApiError.Unknown -> DomainError.ApiError.Unknown(message)
        }
    }
}

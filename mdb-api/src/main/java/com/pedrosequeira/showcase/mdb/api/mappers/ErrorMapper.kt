package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.mdb.api.entities.httpErrorMessage
import com.pedrosequeira.showcase.mdb.api.entities.isHttpError
import com.pedrosequeira.showcase.mdb.api.entities.isNetworkError
import com.pedrosequeira.showcase.mdb.api.entities.isServerError
import com.pedrosequeira.showcase.mdb.api.entities.isUnknownError
import com.pedrosequeira.showcase.mdb.api.entities.networkErrorMessage
import com.pedrosequeira.showcase.mdb.api.entities.unknownErrorMessage
import javax.inject.Inject
import com.pedrosequeira.showcase.data.commons.entities.Error as DataError
import com.pedrosequeira.showcase.mdb.api.entities.Error as ApiError

class ErrorMapper @Inject constructor() {

    fun mapToDataError(apiError: ApiError): DataError = with(apiError) {
        return when {
            isServerError -> DataError.ApiError.ServiceUnavailable
            isHttpError -> DataError.ApiError.ClientError(httpErrorMessage)
            isNetworkError -> DataError.ApiError.NetworkError(networkErrorMessage)
            isUnknownError -> DataError.ApiError.Unknown(unknownErrorMessage)

            else -> throw IllegalStateException("Could not map the api error $this to a data error.")
        }
    }
}

package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.entities.ApiError
import com.pedrosequeira.showcase.mdb.api.extensions.orFalse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import javax.inject.Inject
import okhttp3.ResponseBody

@OptIn(ExperimentalStdlibApi::class)
internal class MdbErrorMapper @Inject constructor() : ErrorMapper {

    override fun mapToDomain(responseBody: ResponseBody): IOResult.Error.NetworkError? {
        val json: String = responseBody.string()
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<ApiError> = moshi.adapter()
        return jsonAdapter.fromJson(json)?.run {
            IOResult.Error.NetworkError(
                statusMessage = statusMessage.orEmpty(),
                success = success.orFalse(),
                statusCode = statusCode ?: 500
            )
        }
    }
}

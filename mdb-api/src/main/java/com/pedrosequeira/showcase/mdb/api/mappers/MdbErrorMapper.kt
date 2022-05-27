package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.mdb.api.entities.ApiError
import javax.inject.Inject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.ResponseBody

internal class MdbErrorMapper @Inject constructor() : ErrorMapper {

    override fun extractErrorMessage(responseBody: ResponseBody): String {
        val json: String = responseBody.string()
        val apiError = Json.decodeFromString<ApiError>(json)
        with(apiError) {
            return statusMessage.orEmpty()
        }
    }
}

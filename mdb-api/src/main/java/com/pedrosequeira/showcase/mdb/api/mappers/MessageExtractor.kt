package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.mdb.api.entities.ApiError
import javax.inject.Inject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.ResponseBody

internal class MessageExtractor @Inject constructor() {

    internal fun extractErrorMessage(responseBody: ResponseBody): String =
        try {
            val json: String = responseBody.string()
            val apiError = Json.decodeFromString<ApiError>(json)
            apiError.statusMessage.orEmpty()
        } catch (exception: Throwable) {
            exception.message ?: exception.javaClass.simpleName
        }
}

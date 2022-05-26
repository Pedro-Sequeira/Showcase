package com.pedrosequeira.showcase.mdb.api.mappers

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import okhttp3.ResponseBody

interface ErrorMapper {
    fun mapToDomain(responseBody: ResponseBody): IOResult.Error.NetworkError?
}

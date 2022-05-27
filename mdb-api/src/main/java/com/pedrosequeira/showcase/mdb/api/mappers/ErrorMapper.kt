package com.pedrosequeira.showcase.mdb.api.mappers

import okhttp3.ResponseBody

interface ErrorMapper {
    fun extractErrorMessage(responseBody: ResponseBody): String
}

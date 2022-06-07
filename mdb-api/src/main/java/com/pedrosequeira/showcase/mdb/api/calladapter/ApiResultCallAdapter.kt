package com.pedrosequeira.showcase.mdb.api.calladapter

import com.pedrosequeira.showcase.mdb.api.ApiResult
import com.pedrosequeira.showcase.mdb.api.mappers.MessageExtractor
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter

internal class ApiResultCallAdapter<R>(
    private val successType: Type,
    private val messageExtractor: MessageExtractor
) : CallAdapter<R, Call<ApiResult<R>>> {

    override fun adapt(call: Call<R>): Call<ApiResult<R>> {
        return ApiResultCall(
            delegate = call,
            successType = successType,
            messageExtractor = messageExtractor
        )
    }

    override fun responseType(): Type = successType
}

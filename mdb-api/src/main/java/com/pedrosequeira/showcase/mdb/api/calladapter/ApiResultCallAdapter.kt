package com.pedrosequeira.showcase.mdb.api.calladapter

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter

internal class ApiResultCallAdapter<R>(
    private val successType: Type,
    private val errorMapper: ErrorMapper
) : CallAdapter<R, Call<IOResult<R>>> {

    override fun adapt(call: Call<R>): Call<IOResult<R>> {
        return ApiResultCall(
            delegate = call,
            successType = successType,
            errorMapper = errorMapper
        )
    }

    override fun responseType(): Type = successType
}

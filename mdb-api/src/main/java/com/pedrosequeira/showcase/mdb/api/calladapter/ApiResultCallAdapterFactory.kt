package com.pedrosequeira.showcase.mdb.api.calladapter

import com.github.michaelbull.result.Result
import com.pedrosequeira.showcase.mdb.api.entities.Error
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit

private const val PARAM_UPPER_BOUND_INDEX_API_RESULT = 0
private const val PARAM_UPPER_BOUND_INDEX_SUCCESS = 0
private const val PARAM_UPPER_BOUND_INDEX_ERROR = 1

internal class ApiResultCallAdapterFactory(
    private val errorMapper: ErrorMapper
) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "Return type must be a parameterized type." }

        val apiResultType = getParameterUpperBound(PARAM_UPPER_BOUND_INDEX_API_RESULT, returnType)
        if (getRawType(apiResultType) != Result::class.java) return null
        check(apiResultType is ParameterizedType) { "Response type must be a parameterized type." }

        val errorType = getParameterUpperBound(PARAM_UPPER_BOUND_INDEX_ERROR, apiResultType)
        if (getRawType(errorType) != Error::class.java) return null

        val successType = getParameterUpperBound(PARAM_UPPER_BOUND_INDEX_SUCCESS, apiResultType)
        return ApiResultCallAdapter<Any>(successType, errorMapper)
    }
}

package com.pedrosequeira.showcase.mdb.api.calladapter

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit

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

        val apiResultType = getParameterUpperBound(0, returnType)
        return when (getRawType(apiResultType)) {
            IOResult::class.java -> ApiResultCallAdapter<Any>(apiResultType, errorMapper)
            else -> null
        }
    }
}

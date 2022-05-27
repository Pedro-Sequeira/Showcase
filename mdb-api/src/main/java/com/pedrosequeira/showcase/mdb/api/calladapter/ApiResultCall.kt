package com.pedrosequeira.showcase.mdb.api.calladapter

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.pedrosequeira.showcase.mdb.api.ApiResult
import com.pedrosequeira.showcase.mdb.api.entities.Error
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import java.io.IOException
import java.lang.reflect.Type
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ApiResultCall<T>(
    private val delegate: Call<T>,
    private val successType: Type,
    private val errorMapper: ErrorMapper
) : Call<ApiResult<T>> {

    override fun enqueue(callback: Callback<ApiResult<T>>) {
        delegate.enqueue(
            onResponse = { _, response ->
                callback.onResponse(
                    this,
                    Response.success(response.toApiResult())
                )
            },
            onFailure = { _, throwable ->
                callback.onResponse(
                    this,
                    Response.success(throwable.toApiResult())
                )
            }
        )
    }

    @Suppress("UNCHECKED_CAST")
    private fun Response<T>.toApiResult(): ApiResult<T> {
        if (!isSuccessful) {
            val httpCode = code()
            val message = errorBody()?.let { errorMapper.extractErrorMessage(it) } ?: ""

            return Err(Error.HttpError(httpCode, message))
        }

        body()?.let { return Ok(it) }

        return if (successType == Unit::class.java) {
            (Ok(Unit) as ApiResult<T>)
        } else {
            Err(Error.UnknownError(IllegalStateException("The response body was null.")))
        }
    }

    private fun <T> Throwable.toApiResult(): ApiResult<T> {
        return Err(
            when (this) {
                is IOException -> Error.NetworkError(this)
                else -> Error.UnknownError(this)
            }
        )
    }

    override fun clone(): Call<ApiResult<T>> {
        return ApiResultCall(delegate.clone(), successType, errorMapper)
    }

    override fun execute(): Response<ApiResult<T>> {
        throw UnsupportedOperationException()
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}


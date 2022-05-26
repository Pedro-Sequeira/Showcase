package com.pedrosequeira.showcase.mdb.api.calladapter

import com.pedrosequeira.showcase.domain.entities.commons.IOResult
import com.pedrosequeira.showcase.domain.entities.commons.IOResult.Error
import com.pedrosequeira.showcase.domain.entities.commons.IOResult.Success
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
) : Call<IOResult<T>> {

    override fun enqueue(callback: Callback<IOResult<T>>) {
        delegate.enqueue(
            onResponse = { _, response ->
                callback.onResponse(
                    this,
                    Response.success(response.toIoResult())
                )
            },
            onFailure = { _, throwable ->
                callback.onResponse(
                    this,
                    Response.success(throwable.toIoResult())
                )
            }
        )
    }

    @Suppress("UNCHECKED_CAST")
    private fun Response<T>.toIoResult(): IOResult<T> {
        if (!isSuccessful) {
            return errorBody()?.let {
                errorMapper.mapToDomain(it)
            } ?: Error.NetworkError()
        }

        body()?.let { return Success(it) }

        return if (successType == Unit::class.java) {
            (Success(Unit) as IOResult<T>)
        } else {
            Error.NetworkError("The response body was null.")
        }
    }

    private fun <T> Throwable.toIoResult(): IOResult<T> {
        return when (this) {
            is IOException -> Error.NetworkUnavailable
            else -> Error.NetworkError()
        }
    }

    override fun clone(): Call<IOResult<T>> {
        return ApiResultCall(delegate.clone(), successType, errorMapper)
    }

    override fun execute(): Response<IOResult<T>> {
        throw UnsupportedOperationException()
    }

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}


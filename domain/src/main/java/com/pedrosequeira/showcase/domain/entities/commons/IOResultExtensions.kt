package com.pedrosequeira.showcase.domain.entities.commons

inline fun <T, R> IOResult<T>.map(transform: (value: T) -> R): IOResult<R> =
    when (this) {
        is IOResult.Success -> IOResult.Success(transform(data))
        is IOResult.Error -> this
    }

inline fun <T, R> IOResult<T>.fold(
    onSuccess: (value: T) -> R,
    onNetworkError: (IOResult.Error.NetworkError) -> R,
    onNetworkUnavailable: () -> R
) = when (this) {
        is IOResult.Success -> onSuccess(data)
        is IOResult.Error.NetworkError -> onNetworkError(this)
        is IOResult.Error.NetworkUnavailable -> onNetworkUnavailable()
    }

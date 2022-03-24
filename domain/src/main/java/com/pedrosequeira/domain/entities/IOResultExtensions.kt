package com.pedrosequeira.domain.entities

inline fun <T, R> IOResult<T>.map(transform: (value: T) -> R): IOResult<R> =
    when (this) {
        is IOResult.Success -> IOResult.Success(transform(data))
        is IOResult.Error -> this
    }

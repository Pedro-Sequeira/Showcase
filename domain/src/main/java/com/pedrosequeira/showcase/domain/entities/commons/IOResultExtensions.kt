package com.pedrosequeira.showcase.domain.entities.commons

inline fun <T, R> IOResult<T>.map(transform: (value: T) -> R): IOResult<R> =
    when (this) {
        is IOResult.Success -> IOResult.Success(transform(data))
        is IOResult.Error -> this
    }

package com.pedrosequeira.showcase.core.extensions

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.mapEither
import com.pedrosequeira.showcase.domain.commons.entities.DomainException
import com.pedrosequeira.showcase.domain.commons.entities.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

fun <S1, E1, S2, E2> Flow<Result<S1, E1>>.mapResult(
    success: (S1) -> S2,
    failure: (E1) -> E2
): Flow<Result<S2, E2>> {
    return map { it.mapEither(success, failure) }
}

fun <T> Flow<Result<T, Error>>.resultOrError(): Flow<T> {
    return map {
        if (it is Ok) return@map it.value
        if (it is Err) throw DomainException(it.error)

        throw IllegalStateException("The result is neither Ok nor Err.")
    }
}

fun <T> Flow<T>.onError(action: suspend FlowCollector<T>.(cause: Throwable) -> Unit): Flow<T> = catch(action)


package com.pedrosequeira.showcase.core

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val computation: CoroutineDispatcher
}

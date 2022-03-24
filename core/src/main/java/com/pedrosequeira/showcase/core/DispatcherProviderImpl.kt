package com.pedrosequeira.showcase.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DispatcherProviderImpl : DispatcherProvider {

    override val main: CoroutineDispatcher = Dispatchers.Main

    override val io: CoroutineDispatcher = Dispatchers.IO

    override val computation: CoroutineDispatcher = Dispatchers.Default
}

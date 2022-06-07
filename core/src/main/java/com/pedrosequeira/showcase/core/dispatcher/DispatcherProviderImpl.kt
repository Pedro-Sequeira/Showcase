package com.pedrosequeira.showcase.core.dispatcher

import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {

    override val main: CoroutineDispatcher = Dispatchers.Main

    override val io: CoroutineDispatcher = Dispatchers.IO

    override val computation: CoroutineDispatcher = Dispatchers.Default
}

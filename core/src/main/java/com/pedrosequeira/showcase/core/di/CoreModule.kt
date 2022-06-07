package com.pedrosequeira.showcase.core.di

import com.pedrosequeira.showcase.core.dispatcher.DispatcherProvider
import com.pedrosequeira.showcase.core.dispatcher.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class CoreModule {

    @Binds
    abstract fun provideDispatcher(dispatcherProviderImpl: DispatcherProviderImpl): DispatcherProvider
}

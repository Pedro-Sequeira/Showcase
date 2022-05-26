package com.pedrosequeira.showcase.mdb.api.di

import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import com.pedrosequeira.showcase.mdb.api.mappers.MdbErrorMapper
import com.pedrosequeira.showcase.mdb.api.service.MoviesEndpoint
import com.pedrosequeira.showcase.mdb.api.service.MoviesEndpointImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class EndpointModule {

    @Binds
    @Singleton
    abstract fun provideEndpoint(impl: MoviesEndpointImpl): MoviesEndpoint

    @Binds
    @Singleton
    abstract fun provideErrorMapper(impl: MdbErrorMapper): ErrorMapper
}

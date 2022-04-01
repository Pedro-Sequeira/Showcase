package com.pedrosequeira.showcase.data.di

import com.pedrosequeira.showcase.data.usecases.GetTopRatedMoviesUseCaseImpl
import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMoviesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideGetTopRatedMoviesUseCase(
        impl: GetTopRatedMoviesUseCaseImpl
    ): GetTopRatedMoviesUseCase
}

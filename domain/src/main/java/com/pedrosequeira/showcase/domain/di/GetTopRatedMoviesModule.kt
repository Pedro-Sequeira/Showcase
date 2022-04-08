package com.pedrosequeira.showcase.domain.di

import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMoviesUseCase
import com.pedrosequeira.showcase.domain.usecases.GetTopRatedMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GetTopRatedMoviesModule {

    @Binds
    @Singleton
    abstract fun provideGetTopRatedMovies(impl: GetTopRatedMoviesUseCaseImpl): GetTopRatedMoviesUseCase
}

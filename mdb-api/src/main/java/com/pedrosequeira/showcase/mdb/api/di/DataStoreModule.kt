package com.pedrosequeira.showcase.mdb.api.di

import com.pedrosequeira.showcase.data.datastores.MoviesRemoteDataStore
import com.pedrosequeira.showcase.mdb.api.datastores.MoviesMdbDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataStoreModule {

    @Binds
    @Singleton
    abstract fun provideMoviesMdbDataStore(impl: MoviesMdbDataStore): MoviesRemoteDataStore
}

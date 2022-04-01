package com.pedrosequeira.showcase.mdb.api.di

import com.pedrosequeira.showcase.mdb.api.BuildConfig
import com.pedrosequeira.showcase.mdb.api.addInterceptorAsFirstInChain
import com.pedrosequeira.showcase.mdb.api.interceptor.AuthenticationInterceptor
import com.pedrosequeira.showcase.mdb.api.service.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object MoviesEndpointModule {

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptorAsFirstInChain(authInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }
}

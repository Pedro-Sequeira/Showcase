package com.pedrosequeira.showcase.mdb.api.di

import com.pedrosequeira.showcase.mdb.api.BuildConfig
import com.pedrosequeira.showcase.mdb.api.addInterceptorAsFirstInChain
import com.pedrosequeira.showcase.mdb.api.calladapter.ApiResultCallAdapterFactory
import com.pedrosequeira.showcase.mdb.api.extensions.asConverterFactory
import com.pedrosequeira.showcase.mdb.api.interceptor.AuthenticationInterceptor
import com.pedrosequeira.showcase.mdb.api.mappers.ErrorMapper
import com.pedrosequeira.showcase.mdb.api.service.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object MoviesEndpointModule {

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
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
    fun provideApiResultCallAdapterFactory(
        errorMapper: ErrorMapper
    ): ApiResultCallAdapterFactory {
        return ApiResultCallAdapterFactory(errorMapper)
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        callAdapterFactory: ApiResultCallAdapterFactory,
        json: Json
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(json.asConverterFactory())
            .build()
    }
}

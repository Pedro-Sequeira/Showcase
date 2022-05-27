package com.pedrosequeira.showcase.mdb.api.interceptor

import com.pedrosequeira.showcase.mdb.api.entities.ApiParams.API_KEY
import com.pedrosequeira.showcase.mdb.api.BuildConfig
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authenticatedUrl = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY)
            .build()

        val authenticatedRequest = chain
            .request()
            .newBuilder()
            .url(authenticatedUrl)
            .build()

        return chain.proceed(authenticatedRequest)
    }
}

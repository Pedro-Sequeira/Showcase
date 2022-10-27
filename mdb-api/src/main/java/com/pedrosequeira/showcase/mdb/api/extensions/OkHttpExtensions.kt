package com.pedrosequeira.showcase.mdb.api.extensions

import okhttp3.Interceptor
import okhttp3.OkHttpClient

private const val INDEX_FIRST_POSITION = 0

fun OkHttpClient.Builder.addInterceptorAsFirstInChain(
    interceptor: Interceptor
): OkHttpClient.Builder = apply {
    interceptors().add(INDEX_FIRST_POSITION, interceptor)
}

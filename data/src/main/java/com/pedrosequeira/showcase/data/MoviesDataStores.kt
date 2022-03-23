package com.pedrosequeira.showcase.data

import javax.inject.Inject

internal class MoviesDataStores @Inject constructor(
    val remote: MoviesRemoteDataStore
)

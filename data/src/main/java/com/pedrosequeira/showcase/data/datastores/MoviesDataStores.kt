package com.pedrosequeira.showcase.data.datastores

import javax.inject.Inject

internal class MoviesDataStores @Inject constructor(
    val remote: MoviesRemoteDataStore
)

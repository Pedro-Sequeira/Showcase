package com.pedrosequeira.showcase.data

import com.pedrosequeira.domain.entities.IOResult

internal interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): IOResult<Nothing>
}

package com.pedrosequeira.showcase.data

import com.pedrosequeira.domain.entities.IOResult
import com.pedrosequeira.showcase.data.entities.DataPagination

interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): IOResult<DataPagination>
}

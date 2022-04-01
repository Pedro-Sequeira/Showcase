package com.pedrosequeira.showcase.data.datastores

import com.pedrosequeira.showcase.data.entities.DataPagination

interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): DataPagination
}

package com.pedrosequeira.showcase.data.datastores

import com.pedrosequeira.showcase.data.commons.DataResult
import com.pedrosequeira.showcase.data.commons.entities.DataPagination
import com.pedrosequeira.showcase.data.movies.DataMovieDetails

interface MoviesRemoteDataStore {

    suspend fun getTopRatedMovies(page: Int): DataPagination

    suspend fun getMovieDetails(id: Int): DataResult<DataMovieDetails>
}
